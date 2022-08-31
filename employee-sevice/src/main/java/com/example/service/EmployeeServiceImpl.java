package com.example.service;

import com.example.domain.DTO;
import com.example.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;
    private List<Employee> employees;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void proConstruct(){
        String resourceUrl = "http://dummy.restapiexample.com/api/v1/employees";
        ResponseEntity<DTO> response = restTemplate.getForEntity(resourceUrl, DTO.class);
        DTO dto = response.getBody();
        employees = dto.getData();
    }

    @Override
    public List<Employee> getEmployeeLarger(int age) {
        List<Employee> res = new LinkedList<>();
        for(Employee emp : employees) {
            if(emp.getEmployee_age() > age) {
                res.add(emp);
            }
        }
        return res;
    }

    @Override
    public Map<Integer, List<Employee>> getEmployees() {
        Map<Integer, List<Employee>> res = new HashMap<>();
        for(Employee emp : employees) {
            int age = emp.getEmployee_age();
            res.putIfAbsent(age, new ArrayList<>());
            res.get(age).add(emp);
        }
        System.out.println(res);
        return res;
    }
}
