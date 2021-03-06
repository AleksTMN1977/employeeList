package pro.sky.jawa.homework.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.jawa.homework.employeelist.data.Employee;
import pro.sky.jawa.homework.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.jawa.homework.employeelist.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName0) {
        Employee employee = new Employee(firstName, lastName0);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName0) {
        Employee employee = new Employee(firstName, lastName0);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName0) {

        Employee employee = new Employee(firstName, lastName0);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
