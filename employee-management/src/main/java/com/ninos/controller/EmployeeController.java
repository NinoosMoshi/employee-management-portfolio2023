package com.ninos.controller;

import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Employee;
import com.ninos.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all-employees")
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getAllEmployees();
    }

}
