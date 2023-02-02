package com.example.learn.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.repo.entity.PermissionEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lichuang
 * @since 2022-10-21
 */
@Repository
public interface PermissionMapper extends BaseMapper<PermissionEntity> {

    /**
     * 角色权限列表集合
     */
    List<PermissionEntity> listByRoleId(@Param("roleIds") List<Integer> roleIds);

}
