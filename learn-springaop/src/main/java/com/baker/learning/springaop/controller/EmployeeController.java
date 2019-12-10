package com.baker.learning.springaop.controller;

import com.baker.learning.springaop.model.Employee;
import com.baker.learning.springaop.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

        return employeeService.createEmployee(name, empId);

    }

    @DeleteMapping(value = "/employee")
    public String removeEmployee(@RequestParam("empId") String empId) {

        employeeService.deleteEmployee(empId);
        log.info("============= controller =============");
        return "Employee removed";
    }

}