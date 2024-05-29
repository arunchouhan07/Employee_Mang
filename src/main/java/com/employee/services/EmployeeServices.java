package com.employee.services;

import com.employee.model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllEmployees();

    void addEmployee(Employee e);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}
