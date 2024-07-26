package com.main.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddTransactionDTO {
    private String title;
    private String description;
    private BigDecimal spend;
    private int type;
}
