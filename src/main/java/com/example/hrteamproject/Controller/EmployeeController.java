package com.example.hrteamproject.Controller;

import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Pojo.DigitalDocument;
import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @CrossOrigin
    @GetMapping("/employee")
    public @ResponseBody
    ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping("/employee")
    public @ResponseBody
    ResponseEntity updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.findById(employee.getId());
        employeeService.updateNameSection(employee1, employee);
        return ResponseEntity.ok("");
    }
//    @PostMapping("/address")
//    public @ResponseBody





}
