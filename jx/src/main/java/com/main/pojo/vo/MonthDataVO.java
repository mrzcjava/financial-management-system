package com.main.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MonthDataVO {
    private String date;
    private BigDecimal spend;
}
