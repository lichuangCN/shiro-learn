package com.example.learn.controller;


import com.example.learn.constant.ServerResponseEnum;
import com.example.learn.pojo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichuang
 * @date 2022/10/21
 */
@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    public ApiResult login(@RequestParam(value = "account") String account,
                           @RequestParam(value = "password") String password) {
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            // 登录验证
            userSubject.login(token);
            return ApiResult.success();
        } catch (UnknownAccountException e) {
            return ApiResult.error(ServerResponseEnum.ACCOUNT_NOT_EXIST);
        } catch (DisabledAccountException e) {
            return ApiResult.error(ServerResponseEnum.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ApiResult.error(ServerResponseEnum.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ApiResult.error(ServerResponseEnum.ERROR);
        }
    }

    @GetMapping("/login")
    public ApiResult login() {
        return ApiResult.error(ServerResponseEnum.NOT_LOGIN_IN);
    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role() {
        return "测试Vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public String permission() {
        return "测试Add和Update权限";
    }
}
