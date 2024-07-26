package com.main.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchTransactionDTO {
    private Integer status;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String keyword;
    private long self;
}
