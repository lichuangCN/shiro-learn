package com.example.learn.repo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.learn.repo.entity.PermissionEntity;

import java.util.List;

/**
 * @author lichuang
 * @since 2022-10-21
 */
public interface IPermissionService extends IService<PermissionEntity> {

    /**
     * 权限集合
     */
    List<String> listPermissionByRoleId(List<Integer> roleIds);
}
