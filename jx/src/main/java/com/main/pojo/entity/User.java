package com.main.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uId;               // 账号
    private int eId;                  // 工号（员工ID）
    private String sfz;               // 身份证
    private String password;          // 密码
    private String phone;             // 手机电话
    private String email;             // 电子邮箱
    private int role;                 // 权限（0为用户，1为管理员）
}