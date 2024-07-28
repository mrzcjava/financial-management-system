package com.main.controller;

import com.main.pojo.dto.AddUserDTO;
import com.main.pojo.dto.RegisterDTO;
import com.main.pojo.dto.SearchEmpDTO;
import com.main.pojo.entity.Employee;
import com.main.result.Result;
import com.main.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@Api(tags = "员工服务")
@RequiredArgsConstructor
@RequestMapping("/employee")
@CrossOrigin
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @ApiOperation("注册功能")
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterDTO registerDTO){
        return employeeService.register(registerDTO);
    }

    @ApiOperation("根据eid查询员工")
    @GetMapping("/{eid}")
    public Result<Object> queryByEId(@PathVariable String eid){
        return employeeService.queryByEId(eid);
    }

    @ApiOperation("查询所有员工")
    @PostMapping
    public Result<Object> all(@RequestBody SearchEmpDTO searchEmpDTO){
        return employeeService.all(searchEmpDTO);
    }

    @ApiOperation("根据员工id删除员工")
    @DeleteMapping("/{eid}")
    public Result<Object> deleteByEId(@PathVariable String eid){
        return employeeService.deleteByEId(eid);
    }

    @ApiOperation("更新员工")
    @PutMapping
    public Result<Object> update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @ApiOperation("添加员工")
    @PostMapping("/add")
    public Result<Object> add(@RequestBody AddUserDTO addUserDTO){
        return employeeService.add(addUserDTO);
    }
}
