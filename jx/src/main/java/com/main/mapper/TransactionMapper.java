package com.main.mapper;

import com.github.pagehelper.Page;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.pojo.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {
    Page<Transaction> queryPage(SearchTransactionDTO sTrDTO);

    void addTransaction(Transaction transaction);

    void pass(String tid);

    void unpass(String tid);
}
