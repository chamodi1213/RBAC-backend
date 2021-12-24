package com.keycloak.springbootkeycloak.dao;

import com.keycloak.springbootkeycloak.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee getEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
