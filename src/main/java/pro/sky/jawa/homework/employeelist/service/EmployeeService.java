package pro.sky.jawa.homework.employeelist.service;

import pro.sky.jawa.homework.employeelist.data.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee add(String firstName, String lastName0);


    Employee remove(String firstName, String lastName0);


    Employee find(String firstName, String lastName0);

    Collection<Employee> findAll();
}
