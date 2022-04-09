package com.example.basiccrudapi.service;

import com.example.basiccrudapi.controller.EmployeeController;
import com.example.basiccrudapi.exception.EmployeeNotFoundException;
import com.example.basiccrudapi.model.Employee;
import com.example.basiccrudapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee find(Integer id) {
        //TODO: validate id
        System.out.println("find: id: " + id);

//        Employee employee = new Employee();
//        Optional<Employee> optional = employeeRepository.findById(id);
//        employee = optional.get();
//        return employee;

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));

        return employee;
    }

    public void save(Employee employee) {
        //TODO: validate employee
        System.out.println("Service: Entity: " + employee);
        employeeRepository.save(employee);
    }

    public String update(Employee employee, Integer id) {
        //TODO: validate employee, id
        System.out.println("update: employee: " + employee);

//        Employee newEmployee = new Employee();
//        Optional<Employee> optional = employeeRepository.findById(id);
//        newEmployee = optional.get();
//
////        newEmployee.setId(employee.getId());
//        newEmployee.setAge(employee.getAge());
//        newEmployee.setName(employee.getName());

        Employee newEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));

        if (employee.getAge() != null) {
            newEmployee.setAge(employee.getAge());
        }

        if (employee.getName() != null) {
            newEmployee.setName(employee.getName());
        }

        employeeRepository.save(newEmployee);
        return "Update Successful";
    }

    public void remove(Integer id) {
        //TODO: validate
        System.out.println("remove: id: " + id);

        try {
            employeeRepository.findById(id);
        } catch (Exception e) {
            System.out.println("error msg: " + e.getMessage());
        }

        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error2 msg: " + e.getMessage());
        }

    }
}
