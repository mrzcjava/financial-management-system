package com.main.service;

import com.main.pojo.dto.AddUserDTO;
import com.main.pojo.dto.RegisterDTO;
import com.main.pojo.dto.SearchEmpDTO;
import com.main.pojo.entity.Employee;
import com.main.result.Result;

public interface EmployeeService {

    Result<String> register(RegisterDTO registerDTO);

    Result<Object> queryByEId(String eid);

    Result<Object> all(SearchEmpDTO searchEmpDTO);

    Result<Object> deleteByEId(String eid);

    Result<Object> update(Employee employee);

    Result<Object> add(AddUserDTO addUserDTO);
}
