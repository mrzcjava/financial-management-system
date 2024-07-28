package com.main.controller;

import cn.hutool.core.util.RandomUtil;
import com.main.context.BaseContext;
import com.main.pojo.dto.LoginDTO;
import com.main.properties.AliOssProperties;
import com.main.result.Result;
import com.main.service.UserService;
import com.main.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Controller
@Api(tags = "通用服务")
@RequiredArgsConstructor
@RequestMapping("/common")
@ResponseBody
@Slf4j
@CrossOrigin
public class CommonController {
    private final UserService userService;
    private final AliOssProperties aliOssProperties;
    private final StringRedisTemplate stringRedisTemplate;
    @ApiOperation("上传头像")
    @PostMapping("/upload/img")
    public Result<Object> img(MultipartFile file){
        String path = "https://sky-take-out-acj.oss-cn-beijing.aliyuncs.com/91cb51c423bd43b998dfb11518b26d9b.jpg";
        AliOssUtil aliOssUtil = new AliOssUtil(aliOssProperties);
        try {
            path = aliOssUtil.upload(file.getBytes(), Objects.requireNonNull(file.getOriginalFilename()));

            userService.modifyImg(path);
            System.out.println(11);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.success(path);
    }

    @ApiOperation("发送验证码")
    @PostMapping("/sendCode")
    public Result<Object> sendCode(){
        String code = RandomUtil.randomNumbers(4);
        log.info("验证码是：{}",code);
        stringRedisTemplate.opsForValue().set("code." + BaseContext.getCurrentId().toString(),code,1, TimeUnit.MINUTES);
        return Result.success();
    }
}
