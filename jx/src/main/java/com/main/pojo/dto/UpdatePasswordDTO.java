package com.main.pojo.dto;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
    private String phoneInput;
    private String code;
    private String passwordFirst;
    private String passwordSecond;
}
