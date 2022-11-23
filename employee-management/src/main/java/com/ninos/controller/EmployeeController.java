package com.ninos.controller;

import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Employee;
import com.ninos.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // get all employees
    @GetMapping("/all-employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }


    // create a new Employee
    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployeeDTO(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // get by id
    @GetMapping("/get-employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employee = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(employeeId);
        EmployeeDTO updateEmployee = employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }


    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        EmployeeDTO employee = employeeService.getEmployee(employeeId);
       employeeService.deleteEmployee(employeeId);
       return new ResponseEntity<>("The employee "+ employee.getFirstName() + " was delete successfully",HttpStatus.OK);
    }


}
