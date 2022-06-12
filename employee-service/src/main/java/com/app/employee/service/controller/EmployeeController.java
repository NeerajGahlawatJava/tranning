package com.app.employee.service.controller;

import com.app.employee.service.entity.Employee;
import com.app.employee.service.repository.EmployeeRepository;
import com.app.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveStudent(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return  employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") int id){
        employeeService.removeEmployee(id);
        return new ResponseEntity<>("Employee delete successfully! with id "+id, HttpStatus.OK);
    }
}
