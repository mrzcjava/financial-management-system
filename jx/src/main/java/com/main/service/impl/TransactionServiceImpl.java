package com.main.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.main.mapper.TransactionMapper;
import com.main.pojo.dto.AddTransactionDTO;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.pojo.entity.Transaction;
import com.main.result.Result;
import com.main.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionMapper transactionMapper;
    @Override
    public Result<Object> all(Integer pageNum, SearchTransactionDTO sTrDTO) {
        Page<Transaction> ts;

        PageHelper.startPage(pageNum, 20);
        ts = transactionMapper.queryPage(sTrDTO);

        return Result.success(ts);
    }

    // TODO 添加事务
    @Override
    public Result<Object> add(AddTransactionDTO addTrDTO) {
        return null;
    }
}
