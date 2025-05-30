package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import io.swagger.models.auth.In;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 增加员工
     *
     * @param employeeDTO
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 分页查询员工
     *
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQueryEmployee(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据ID修改员工状态
     *
     * @param status
     * @param id
     */
    void modifyStatus(Integer status, Long id);

    /**
     * 根据ID修改员工信息
     * @param employeeDTO
     */
    void modifyEmployee(EmployeeDTO employeeDTO);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Employee getEmployeeById(Long id);
}
