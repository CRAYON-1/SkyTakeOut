package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import com.sky.annotation.AutoFill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 增加员工
     *
     * @param employee
     */
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into employee (username, name, password, phone, sex, id_number, create_time, update_time, create_user, update_user) values (#{username}, #{name}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void addEmployee(Employee employee);

    /**
     * 分页查询员工
     *
     * @param name
     * @return
     */
    Page<Employee> queryEmployee(String name);

    /**
     * 根据ID修改员工状态
     * @param employee
     */
    @AutoFill(value = OperationType.UPDATE)
    void updateEmployee(Employee employee);

    /**
     * 根据ID查询员工
     *
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
