package com.main.mapper;

import com.main.pojo.dto.RegisterDTO;
import com.main.pojo.dto.SearchEmpDTO;
import com.main.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee queryEmpByRegisterDTO(RegisterDTO registerDTO);

    Employee queryByEId(String eid);

    List<Employee> all(SearchEmpDTO searchEmpDTO);

    void deleteByEId(String eid);

    void update(Employee employee);

    void add(Employee employee);

    void setComment(String comment, String eid);
}
