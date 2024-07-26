package com.main.controller;

import com.main.pojo.dto.AddTransactionDTO;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.result.Result;
import com.main.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@Api(tags = "事务服务")
@RequiredArgsConstructor
@RequestMapping("/tx")
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    @ApiOperation("查询所有事务")
    @GetMapping
    public Result<Object> all(Integer pageNum, SearchTransactionDTO searchTrDTO){
        return transactionService.all(pageNum, searchTrDTO);
    }

    @ApiOperation("添加事务")
    @PutMapping
    public Result<Object> add(@RequestBody AddTransactionDTO addTrDTO){
        return transactionService.add(addTrDTO);
    }
}
