package com.example.learn.repo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.learn.repo.entity.RoleEntity;

import java.util.List;

/**
 * @author lichuang
 * @since 2022-10-21
 */
public interface IRoleService extends IService<RoleEntity> {

    List<RoleEntity> listByUserId(Integer userId);
}
