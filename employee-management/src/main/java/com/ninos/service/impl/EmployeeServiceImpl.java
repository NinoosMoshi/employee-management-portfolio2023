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
import java.util.Optional;
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
        return employees.stream().map(temp -> entityToDto(temp)).collect(Collectors.toList());

//       1- first way
//       List<EmployeeDTO> employeeListDTO = new ArrayList<>();
//       for (int i=0; i<employees.size(); i++){
//          EmployeeDTO employeeDTO = modelMapper.map(employees.get(i),EmployeeDTO.class);
//           employeeListDTO.add(employeeDTO);
//       }
//       return employeeListDTO;


    }


    // create new Employee
    @Override
    public EmployeeDTO createEmployeeDTO(EmployeeDTO employeeDTO) {
        Employee employee = dtoToEntity(employeeDTO);
        Employee newEmployee = employeeRepository.save(employee);

        EmployeeDTO employeeDTO1 = entityToDto(newEmployee);
        return employeeDTO1;
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee1 = employee.get();
        return entityToDto(employee1);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(employeeDTO.getId()).get();
        existingEmployee.setEmployeeCode(employeeDTO.getEmployeeCode());
        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setGender(employeeDTO.getGender());
        existingEmployee.setJobTitle(employeeDTO.getJobTitle());
        existingEmployee.setPhone(employeeDTO.getPhone());
        Employee employeeEntity = employeeRepository.save(existingEmployee);
        return entityToDto(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    // convert Entity to DTO
    public EmployeeDTO entityToDto(Employee employee){
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    // convert DTO to Entity
    public Employee dtoToEntity(EmployeeDTO employeeDTO){
         Employee employee = modelMapper.map(employeeDTO, Employee.class);
         return employee;
    }








}
