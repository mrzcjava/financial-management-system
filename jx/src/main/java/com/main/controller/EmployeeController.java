package com.main.controller;

import com.main.pojo.dto.RegisterDTO;
import com.main.result.Result;
import com.main.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Api(tags = "员工服务")
@RequiredArgsConstructor
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @ApiOperation("注册功能")
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterDTO registerDTO){
        return employeeService.register(registerDTO);
    }
}
