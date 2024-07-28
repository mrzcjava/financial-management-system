package com.main.service;

import com.main.pojo.dto.AddTransactionDTO;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.result.Result;

public interface TransactionService {

    Result<Object> all(Integer pageNum, SearchTransactionDTO sTrDTO);

    Result<Object> add(AddTransactionDTO addTrDTO);

    Result<Object> pass(String tid);

    Result<Object> unpass(String tid);

    Result<Object> get();
}
