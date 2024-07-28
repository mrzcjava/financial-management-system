package com.main.service.impl;

import com.main.context.BaseContext;
import com.main.context.JwtClaimsConstant;
import com.main.mapper.EmployeeMapper;
import com.main.mapper.UserMapper;
import com.main.pojo.dto.LoginDTO;
import com.main.pojo.dto.ModifyNameAndCommentDTO;
import com.main.pojo.dto.UpdatePasswordDTO;
import com.main.pojo.entity.User;
import com.main.pojo.vo.LoginVO;
import com.main.properties.JwtProperties;
import com.main.result.Result;
import com.main.service.UserService;
import com.main.utils.JwtUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private JwtProperties jwtProperties;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
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

        System.out.println(BaseContext.getCurrentId());
        return Result.success(loginVO);
    }

    @Override
    public void modifyImg(String path) {
        userMapper.modifyImg(path,BaseContext.getCurrentId());
    }

    @Override
    public Result<Object> modifyNameAndComment(ModifyNameAndCommentDTO dto) {
        userMapper.setUid(dto.getUid(),BaseContext.getCurrentId().toString());
        employeeMapper.setComment(dto.getComment(), BaseContext.getCurrentId().toString());
        return Result.success();
    }

    @Override
    public Result<Object> updatePwd(UpdatePasswordDTO dto) {
        String code = stringRedisTemplate.opsForValue().get("code." + BaseContext.getCurrentId().toString());
        if (!Objects.equals(code, dto.getCode())){
            return  Result.error("验证码不正确");
        }

        String password = DigestUtils.md5DigestAsHex(dto.getPasswordFirst().getBytes());
        userMapper.updatePwd(password, BaseContext.getCurrentId().toString());
        return Result.success();
    }

}
