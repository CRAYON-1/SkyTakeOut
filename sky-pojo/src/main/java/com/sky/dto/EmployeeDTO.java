package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("员工DTO")
public class EmployeeDTO implements Serializable {
    @ApiModelProperty("员工ID")
    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}
