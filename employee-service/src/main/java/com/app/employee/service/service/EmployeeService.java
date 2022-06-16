package com.app.employee.service.service;

import com.app.employee.service.entity.Employee;
import com.app.employee.service.exception.EmployeeException;
import com.app.employee.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveStudent(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new EmployeeException("");
        }
    }

    public void removeEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("");
        }
        employeeRepository.delete(employee);
    }

    @Async
    public void getMsg() {
        deplay(2);
        System.out.println(10 / 0);
        System.out.println("Thread in Service :" + Thread.currentThread().getName());
    }

    @Async
    public CompletableFuture<List<Employee>> saveEmployees(MultipartFile file) {
        long startTime = System.currentTimeMillis();
        List<Employee> employeeList = pareCSVFile(file);
        System.out.println("Saveing list of users of size() : " + employeeList.size()+ " "+Thread.currentThread().getName());
        employeeRepository.saveAll(employeeList);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time : " +(endTime-startTime));
        return CompletableFuture.completedFuture(employeeList);
    }

    @Async
    public CompletableFuture<List<Employee>> findAllEmployees(){
        System.out.println("Saveing list of users of size() : "+Thread.currentThread().getName());
          List<Employee>  employees =   employeeRepository.findAll();
          return CompletableFuture.completedFuture(employees);
    }

    private List<Employee> pareCSVFile(MultipartFile file) {
        final List<Employee> employeeList = new ArrayList<>();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                final String[] data = line.split(",");
                if(!data[0].equals("empId")){
                    Employee employee = new Employee();
                    employee.setEmpId(Integer.parseInt(data[0]));
                    employee.setEmpName(data[1]);
                    employeeList.add(employee);
                }
            }

        } catch (Exception e) {
        e.printStackTrace();
        }
        return employeeList;
    }

    public static void deplay(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
