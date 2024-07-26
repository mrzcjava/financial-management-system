package com.main.controller;

import com.main.pojo.dto.LoginDTO;
import com.main.result.Result;
import com.main.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "用户服务")
@RequiredArgsConstructor
@RequestMapping("/user")
@ResponseBody
@Slf4j
@CrossOrigin
public class UserController {
    private final UserService userService;

    @ApiOperation("登录功能")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }
}
