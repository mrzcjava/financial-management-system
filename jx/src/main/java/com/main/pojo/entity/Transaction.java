package com.main.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private int tId;                  // 事务ID
    private int uId;                  // 发起人（用户ID）
    private Integer aId;              // 受理人（用户ID）
    private String title;             // 事务标题
    private String description;       // 事务描述
    private BigDecimal spend;         // 事务花费
    private LocalDateTime beginTime;           // 开始时间
    private LocalDateTime endTime;             // 结束时间
    private String file;              // 受理文件
    private int status;               // 事务状态
    private int repeat;               // 是否被举办（要求重新审核）
    private int type;                 // 事务类型
    private String img;
}