package com.employee.controller;

import com.employee.model.Employee;
import com.employee.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public String getEmployee(Model model){
        model.addAttribute("allemplist",employeeServices.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String addNewEmployee(Model model){
        Employee e=new Employee();
        model.addAttribute("addemployee",e);
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServices.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id")Long id, Model model){
        Employee employee=employeeServices.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id")Long id){
        employeeServices.deleteEmployee(id);
        return "redirect:/";
    }


}
