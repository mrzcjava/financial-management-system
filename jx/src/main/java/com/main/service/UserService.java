package com.main.service;

import com.main.pojo.dto.LoginDTO;
import com.main.result.Result;

public interface UserService {

    Result<Object> login(LoginDTO loginDTO);
}
