package com.keycloak.springbootkeycloak.dao;

import com.keycloak.springbootkeycloak.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImp (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId", id);

        query.executeUpdate();

    }
}
