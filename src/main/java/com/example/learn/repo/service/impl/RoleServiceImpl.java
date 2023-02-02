package com.example.learn.repo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.learn.repo.entity.RoleEntity;
import com.example.learn.repo.mapper.RoleMapper;
import com.example.learn.repo.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lichuang
 * @since 2022-10-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService {

    @Override
    public List<RoleEntity> listByUserId(Integer userId) {
        return this.baseMapper.listRoleByUserId(userId);
    }
}
