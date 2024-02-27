package com.pbogdanovich.rest.controller;

import com.pbogdanovich.rest.entity.Employee;
import com.pbogdanovich.rest.exception_handlers.EmployeeIncorrectData;
import com.pbogdanovich.rest.exception_handlers.NoSuchEmployeeException;
import com.pbogdanovich.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("There is no employee with id " + id);
        }
        return employee;
    }
    //test11

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
            employeeService.setEmployee(employee);
            return employee;
    }

    @PostMapping("/employees")
    public Employee addTestNewEmployee(@RequestBody Employee employee){
        employeeService.setEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.setEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.getEmployee(id) == null){
            throw new NoSuchEmployeeException("There is no employee with id " + id);
        }
        employeeService.deleteEmployee(id);
        return "Employee " + id + "was deleted";
    }

    @GetMapping("/test")
    public String welcome() {
        return "Welcome to the Employee Management System!";
    }
}
