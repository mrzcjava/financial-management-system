package com.main.pojo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Employee {

    private int eId;                  // 用户id（工号）
    private String name;              // 员工姓名
    private String sfz;               // 身份证
    private String position;          // 职位名字
    private String sector;            // 公司系部
    private BigDecimal salary;        // 薪水
    private String address;           // 家庭住址
    private LocalDateTime beginTime;           // 入职时间
    private String comment;           // 个性签名
    private String type;              // 员工类型（全职，兼职，实习）
    private int level;                // 员工等级（0到10，实习和兼职默认为0）
}