package com.main.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.main.context.BaseContext;
import com.main.mapper.TransactionMapper;
import com.main.pojo.dto.AddTransactionDTO;
import com.main.pojo.dto.SearchTransactionDTO;
import com.main.pojo.entity.Transaction;
import com.main.pojo.vo.MonthDataVO;
import com.main.pojo.vo.SectorDataVO;
import com.main.pojo.vo.SummeryDataVO;
import com.main.properties.AliOssProperties;
import com.main.result.Result;
import com.main.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionMapper transactionMapper;
    @Resource
    private AliOssProperties aliOssProperties;
    @Override
    public Result<Object> all(Integer pageNum, SearchTransactionDTO sTrDTO) {
        Page<Transaction> ts;

        PageHelper.startPage(pageNum, 20);
        ts = transactionMapper.queryPage(sTrDTO);

        return Result.success(ts);
    }

    @Override
    public Result<Object> add(AddTransactionDTO addTrDTO) {
        System.out.println(addTrDTO);

        Transaction transaction = Transaction.builder()
                .title(addTrDTO.getTitle())
                .description(addTrDTO.getDescription())
                .type(addTrDTO.getType())
                .spend(BigDecimal.valueOf(addTrDTO.getSpend()))
                .status(0)
                .beginTime(LocalDateTime.now())
                .file(addTrDTO.getFile())
                .repeat(0)
                .tId(RandomUtil.randomInt(100000))
                .uId(BaseContext.getCurrentId().intValue())
                .build();
        transactionMapper.addTransaction(transaction);
        return Result.success("添加成功");
    }

    @Override
    public Result<Object> pass(String tid) {
        transactionMapper.pass(tid);
        return Result.success();
    }

    @Override
    public Result<Object> unpass(String tid) {
        transactionMapper.unpass(tid);
        return Result.success();
    }

    @Override
    public Result<Object> get() {
        List<MonthDataVO> monthDate = transactionMapper.getMonth();
        List<SectorDataVO> monthSector = transactionMapper.getMonthSector();
        List<MonthDataVO> seasonData = transactionMapper.getSeasonData();
        List<SectorDataVO> seasonSector = transactionMapper.getSeasonSector();
        SummeryDataVO vo = SummeryDataVO.builder()
                .seasonData(seasonData)
                .monthSector(monthSector)
                .seasonSector(seasonSector)
                .monthData(monthDate).build();
        return Result.success(vo);
    }
}
