package com.main.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.main.mapper.EmployeeMapper;
import com.main.mapper.UserMapper;
import com.main.pojo.dto.AddUserDTO;
import com.main.pojo.dto.RegisterDTO;
import com.main.pojo.dto.SearchEmpDTO;
import com.main.pojo.entity.Employee;
import com.main.pojo.entity.User;
import com.main.result.Result;
import com.main.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Result<String> register(RegisterDTO registerDTO) {
        // 1.查询员工是否存在， 不存在直接返回错误消息
        int role = registerDTO.getRole();
        Employee employee = employeeMapper.queryEmpByRegisterDTO(registerDTO);

        if (employee == null){
            return Result.error("未找到该员工");
        }

        User userTouch = userMapper.queryUserByEId(employee.getEId());

        if (userTouch != null && userTouch.getRole() == role){
            return Result.error("账号已存在");
        }
        if (ObjUtil.isNull(employee)){
            return Result.error("未查询到该员工！");
        }
        if (role > 0 && employee.getLevel() <= 5){
            return Result.error("创建管理员账号失败");
        }
        // 2.为员工注册一个用户
        // 2.1 创建账户密码，密码默认为身份证后六位
        String sfz = registerDTO.getSfz();
        String username = "jx"+employee.getEId();
        String password = DigestUtils.md5DigestAsHex(sfz.substring(sfz.length()-6).getBytes());

        User user = User.builder().eId(registerDTO.getEmpId()).password(password).uId(username).role(role).build();
        int res = userMapper.addNewUser(user);

        if (res < 1){
            return Result.error("未知错误，注册失败");
        }

        return Result.success("注册成功！账号为 jx 加工号，密码默认为身份证后六位");
    }

    @Override
    public Result<Object> queryByEId(String eid) {
        Employee employee = employeeMapper.queryByEId(eid);
        return Result.success(employee);
    }

    @Override
    public Result<Object> all(SearchEmpDTO searchEmpDTO) {
        List<Employee> employees = employeeMapper.all(searchEmpDTO);
        return Result.success(employees);
    }

    @Override
    public Result<Object> deleteByEId(String eid) {
        employeeMapper.deleteByEId(eid);
        return Result.success();
    }

    @Override
    public Result<Object> update(Employee employee) {
        employeeMapper.update(employee);
        return Result.success();
    }

    @Override
    public Result<Object> add(AddUserDTO addUserDTO) {
        Employee employee = Employee.builder()
                .name(addUserDTO.getName())
                .eId(addUserDTO.getEmpId())
                .position(addUserDTO.getPosition())
                .level(addUserDTO.getLevel())
                .address(addUserDTO.getAddress())
                .sector(addUserDTO.getSector())
                .salary(addUserDTO.getSalary())
                .comment(null)
                .sfz(addUserDTO.getSfz())
                .beginTime(LocalDateTime.now())
                .type(addUserDTO.getType())
                .build();

        employeeMapper.add(employee);

        return Result.success();
    }
}
