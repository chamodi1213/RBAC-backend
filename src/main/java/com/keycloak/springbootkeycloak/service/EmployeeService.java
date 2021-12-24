package com.keycloak.springbootkeycloak.service;

import com.keycloak.springbootkeycloak.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee getEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
