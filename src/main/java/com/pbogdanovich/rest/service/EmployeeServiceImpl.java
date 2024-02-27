package com.pbogdanovich.rest.service;

import com.pbogdanovich.rest.dao.EmployeeDao;
import com.pbogdanovich.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    @Qualifier("employeeDAOImpl")
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public Employee getEmployee(int employeeId) {
        return employeeDao.getEmployee(employeeId);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public void setEmployee(Employee employee) {
        employeeDao.setEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }
}
