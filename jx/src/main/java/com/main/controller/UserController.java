package com.main.controller;

import com.main.pojo.dto.LoginDTO;
import com.main.pojo.dto.ModifyNameAndCommentDTO;
import com.main.pojo.dto.UpdatePasswordDTO;
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

    @ApiOperation("更新账户名 uid 和 员工的个性标签")
    @PostMapping("/modifyNameAndComment")
    public Result<Object> modifyNameAndComment(@RequestBody ModifyNameAndCommentDTO dto){
        return userService.modifyNameAndComment(dto);
    }

    @ApiOperation("修改密码")
    @PutMapping("/password")
    public Result<Object> updatePwd(@RequestBody UpdatePasswordDTO dto){
        return userService.updatePwd(dto);
    }
}
