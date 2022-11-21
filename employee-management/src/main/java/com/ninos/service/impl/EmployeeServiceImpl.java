package com.ninos.service.impl;

import com.ninos.dao.EmployeeRepository;
import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Employee;
import com.ninos.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
        // 2- second way
        return employees.stream().map(temp -> EntityToDto(temp)).collect(Collectors.toList());

//       1- first way
//       List<EmployeeDTO> employeeListDTO = new ArrayList<>();
//       for (int i=0; i<employees.size(); i++){
//          EmployeeDTO employeeDTO = modelMapper.map(employees.get(i),EmployeeDTO.class);
//           employeeListDTO.add(employeeDTO);
//       }
//       return employeeListDTO;


    }


    // convert Entity to DTO
    public EmployeeDTO EntityToDto(Employee employee){
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    // convert DTO to Entity
    public Employee DtoToEntity(EmployeeDTO employeeDTO){
         Employee employee = modelMapper.map(employeeDTO, Employee.class);
         return employee;
    }








}
