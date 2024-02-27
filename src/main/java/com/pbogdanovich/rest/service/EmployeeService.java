package com.pbogdanovich.rest.service;

import com.pbogdanovich.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void setEmployee(Employee employee);
    public Employee getEmployee(int employeeId);
    public void deleteEmployee(int employeeId);
}
