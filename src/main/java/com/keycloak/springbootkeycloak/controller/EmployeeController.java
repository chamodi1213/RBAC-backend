package com.keycloak.springbootkeycloak.controller;

import com.keycloak.springbootkeycloak.entity.Employee;
import com.keycloak.springbootkeycloak.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmpolyeeHome(){
        return "Welcome to API Home";
    }

    @GetMapping("/employees")
    @RolesAllowed({"admin", "user"})
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    @RolesAllowed({"admin", "user"})
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("EmployeeId - " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    @RolesAllowed("admin")
    public Employee saveNewEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.saveEmployee(employee);

        return employee;
    }
}
