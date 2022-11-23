package com.ninos.dto;

import lombok.Data;


@Data
public class EmployeeDTO {

    private Long id;
    private String EmployeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String phone;
    private String gender;

}
