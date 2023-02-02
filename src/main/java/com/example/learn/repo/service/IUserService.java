package com.example.learn.repo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.learn.repo.entity.UserEntity;

/**
 * @author lichuang
 * @since 2022-10-21
 */
public interface IUserService extends IService<UserEntity> {

    UserEntity getByAccount(String account);
}
