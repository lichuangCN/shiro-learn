package com.example.learn.repo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learn.repo.entity.UserEntity;
import com.example.learn.repo.mapper.UserMapper;
import com.example.learn.repo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author lichuang
 * @since 2022-10-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public UserEntity getByAccount(String account) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getAccount, account);
        return this.baseMapper.selectOne(wrapper);
    }
}
