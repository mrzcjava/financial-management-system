package com.main.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddUserDTO {
    private String name;
    private Integer empId;
    private String sfz;
    private String position;
    private Integer sector;
    private Integer level;
    private BigDecimal salary;
    private String address;
    private String type;
}
