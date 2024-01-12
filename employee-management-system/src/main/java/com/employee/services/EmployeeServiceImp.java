package com.employee.services;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeServices{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee e) {
        if(Objects.nonNull(e)){
            employeeRepository.save(e);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee=null;
        if(Objects.nonNull(id)){
            Optional<Employee> optionalEmployee=employeeRepository.findById(id);
            if(optionalEmployee.isPresent()){
                employee=optionalEmployee.get();
            }else{
                throw new RuntimeException("Employee Not Found with the id: "+id);
            }
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        if(Objects.nonNull(id)){
            employeeRepository.deleteById(id);
        }
    }
}
