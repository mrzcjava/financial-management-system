package com.main.service;

import com.main.pojo.dto.LoginDTO;
import com.main.pojo.dto.ModifyNameAndCommentDTO;
import com.main.pojo.dto.UpdatePasswordDTO;
import com.main.result.Result;

public interface UserService {

    Result<Object> login(LoginDTO loginDTO);

    void modifyImg(String path);

    Result<Object> modifyNameAndComment(ModifyNameAndCommentDTO dto);

    Result<Object> updatePwd(UpdatePasswordDTO dto);
}
