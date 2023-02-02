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
@TableName("user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -6056125703075132981L;

    private Integer id;

    private String account;

    private String password;

    private String username;
}