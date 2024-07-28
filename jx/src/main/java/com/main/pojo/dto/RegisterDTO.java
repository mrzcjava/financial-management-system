package com.main.pojo.dto;

import lombok.Data;


@Data
public class RegisterDTO {
    private Integer empId;    // 工号
    private String sfz;     // 身份证
    private Integer role;   // 权限（是否创建管理员账户）
}
