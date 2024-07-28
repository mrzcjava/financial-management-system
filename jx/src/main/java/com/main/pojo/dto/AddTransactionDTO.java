package com.main.pojo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class AddTransactionDTO {
    private String title;
    private String description;
    private Long spend;
    private int type;
    private String file;
}
