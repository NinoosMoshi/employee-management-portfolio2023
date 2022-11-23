package com.ninos.service;

import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO createEmployeeDTO(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(Long id);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}
