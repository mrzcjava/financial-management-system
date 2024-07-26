package com.main.service.impl;

import com.main.context.BaseContext;
import com.main.context.JwtClaimsConstant;
import com.main.mapper.UserMapper;
import com.main.pojo.dto.LoginDTO;
import com.main.pojo.entity.User;
import com.main.pojo.vo.LoginVO;
import com.main.properties.JwtProperties;
import com.main.result.Result;
import com.main.service.UserService;
import com.main.utils.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private JwtProperties jwtProperties;
    @Override
    public Result<Object> login(LoginDTO loginDTO) {
        String password = loginDTO.getPassword();

        User user = userMapper.queryUserById(loginDTO.getUsername());

        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
            return Result.error("密码不匹配！");
        }

        // 制作 token
        Map<String, Object> claims = new HashMap<>(1);
        BaseContext.setCurrentId((long) user.getEId());
        claims.put(JwtClaimsConstant.EMP_ID, user.getEId());

        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        LoginVO loginVO = LoginVO.builder().user(user).token(token).build();
        return Result.success(loginVO);
    }
}
