package com.main.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchEmpDTO {
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String keyword;
}
