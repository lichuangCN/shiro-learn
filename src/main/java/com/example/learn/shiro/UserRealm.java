package com.example.learn.shiro;

import com.example.learn.repo.entity.RoleEntity;
import com.example.learn.repo.entity.UserEntity;
import com.example.learn.repo.service.IPermissionService;
import com.example.learn.repo.service.IRoleService;
import com.example.learn.repo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 负责认证用户身份和对用户进行授权
 *
 * @author lichuang
 * @date 2022/10/21
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserEntity user = (UserEntity) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<RoleEntity> roleList = roleService.listByUserId(user.getId());
        // 放入角色信息
        Set<String> roleSet = roleList.stream().map(RoleEntity::getRole).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleSet);

        // 放入权限信息
        List<Integer> roleId = roleList.stream().map(RoleEntity::getId).collect(Collectors.toList());
        List<String> permissionList = permissionService.listPermissionByRoleId(roleId);
        authorizationInfo.setStringPermissions(new HashSet<>(permissionList));
        return authorizationInfo;
    }

    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // token.getCredentials() 密码
        UserEntity user = userService.getByAccount(token.getUsername());
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
