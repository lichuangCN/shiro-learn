package com.example.learn.repo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lichuang
 * @date 2022/10/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("role")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;
}