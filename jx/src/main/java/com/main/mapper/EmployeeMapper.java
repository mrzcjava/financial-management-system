package com.main.mapper;

import com.main.pojo.dto.RegisterDTO;
import com.main.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee queryEmpByRegisterDTO(RegisterDTO registerDTO);
}
