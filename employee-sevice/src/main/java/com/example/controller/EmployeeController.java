package com.example.controller;


import com.example.domain.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public ResponseEntity<?> getEmployees() {
        try{
            return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/employee/", params = "age")
    public ResponseEntity<List<Employee>> getAllEmployeesLager(@RequestParam int age) {
        return new ResponseEntity<>(employeeService.getEmployeeLarger(age), HttpStatus.OK);
    }
}
