package com.main.mapper;

import com.github.pagehelper.Page;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.pojo.entity.Transaction;
import com.main.pojo.vo.MonthDataVO;
import com.main.pojo.vo.SectorDataVO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface TransactionMapper {
    Page<Transaction> queryPage(SearchTransactionDTO sTrDTO);

    void addTransaction(Transaction transaction);

    void pass(String tid);

    void unpass(String tid);

    List<SectorDataVO> getMonthSector();

    List<MonthDataVO> getMonth();

    List<SectorDataVO> getSeasonSector();

    List<MonthDataVO> getSeasonData();
}
