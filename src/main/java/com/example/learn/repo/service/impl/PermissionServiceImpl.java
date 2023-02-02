package com.example.learn.repo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learn.repo.entity.PermissionEntity;
import com.example.learn.repo.mapper.PermissionMapper;
import com.example.learn.repo.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lichuang
 * @since 2022-10-21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionEntity> implements IPermissionService {

    @Override
    public List<String> listPermissionByRoleId(List<Integer> roleIds) {
        List<PermissionEntity> list = this.baseMapper.listByRoleId(roleIds);
        return list.stream().map(PermissionEntity::getPermission).distinct().collect(Collectors.toList());
    }
}
