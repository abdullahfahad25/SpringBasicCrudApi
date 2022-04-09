package com.example.basiccrudapi.controller;

import com.example.basiccrudapi.model.Employee;
import com.example.basiccrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basic-crud")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        System.out.println("in Controller: get");

//        Employee employee = new Employee(2, "Vols", 33);
        Employee employee = employeeService.find(id);
        ResponseEntity response = new ResponseEntity<>(employee, HttpStatus.OK);
        return response;
    }

    @PostMapping("/post")
    public String postEmployee(@RequestBody Employee employee) {
        System.out.println("in Controller: post");
        System.out.println("Entity: " + employee);

        employeeService.save(employee);
        return "post Successful";
    }

    @PutMapping("/put/{id}")
    public String putEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        System.out.println("in Controller: put");

        String msg = employeeService.update(employee, id);
        return msg;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        System.out.println("in Controller: delete");

        employeeService.remove(id);
        return "delete Successful";
    }
}
