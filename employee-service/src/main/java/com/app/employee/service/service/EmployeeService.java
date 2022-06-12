package com.app.employee.service.service;

import com.app.employee.service.entity.Employee;
import com.app.employee.service.exception.EmployeeException;
import com.app.employee.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveStudent(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        } else {
            throw new EmployeeException("");
        }
    }

    public void removeEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if(employee == null){
            throw new EmployeeException("");
        }
        employeeRepository.delete(employee);
    }
}
