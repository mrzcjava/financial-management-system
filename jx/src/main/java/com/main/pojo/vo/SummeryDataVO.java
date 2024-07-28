package com.main.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummeryDataVO {
    private List<MonthDataVO> monthData;
    private List<SectorDataVO> monthSector;
    private List<MonthDataVO> seasonData;
    private List<SectorDataVO> seasonSector;
}
