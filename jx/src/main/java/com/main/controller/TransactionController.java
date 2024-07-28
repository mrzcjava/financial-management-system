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
@CrossOrigin
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;

    @ApiOperation("查询所有事务")
    @PostMapping
    public Result<Object> all(Integer pageNum,@RequestBody SearchTransactionDTO searchTrDTO){
        return transactionService.all(pageNum, searchTrDTO);
    }

    @ApiOperation("添加事务")
    @PutMapping
    public Result<Object> add(@RequestBody AddTransactionDTO addTrDTO){
        return transactionService.add(addTrDTO);
    }

    @ApiOperation("通过审核")
    @PostMapping("/pass/{tid}")
    public Result<Object> pass(@PathVariable String tid){
        return transactionService.pass(tid);
    }

    @ApiOperation("未通过审核")
    @PostMapping("/unpass/{tid}")
    public Result<Object> unpass(@PathVariable String tid){
        return transactionService.unpass(tid);
    }
}
