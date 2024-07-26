package com.main.service;

import com.main.pojo.dto.RegisterDTO;
import com.main.result.Result;

public interface EmployeeService {

    Result<String> register(RegisterDTO registerDTO);
}
