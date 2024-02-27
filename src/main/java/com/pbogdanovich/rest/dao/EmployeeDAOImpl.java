package com.pbogdanovich.rest.dao;

import com.pbogdanovich.rest.entity.Employee;
import com.pbogdanovich.rest.exception_handlers.EmployeeIncorrectData;
import com.pbogdanovich.rest.exception_handlers.NoSuchEmployeeException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
@Repository("employeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void setEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, employeeId);
        return employee;

    }

    @Override
    public void deleteEmployee(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, employeeId);
        session.remove(employee);
    }
}
