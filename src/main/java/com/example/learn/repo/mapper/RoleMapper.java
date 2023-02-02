package com.example.learn.repo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.repo.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lichuang
 * @since 2022-10-21
 */
@Repository
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 人员角色列表
     */
    List<RoleEntity> listRoleByUserId(@Param("userId") Integer userId);
}
