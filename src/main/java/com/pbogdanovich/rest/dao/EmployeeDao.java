package com.pbogdanovich.rest.dao;

import com.pbogdanovich.rest.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public void setEmployee(Employee employee);
    public Employee getEmployee(int employeeId);
    public void deleteEmployee(int employeeId);


}