package com.example.hrteamproject.Controller;

import com.example.hrteamproject.Dao.AddressRepository;
import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Pojo.*;
import com.example.hrteamproject.Server.AddressService;
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

    @Autowired
    AddressService addressService;

    @CrossOrigin
    @GetMapping("/employee")
    public @ResponseBody
    ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @CrossOrigin
    @GetMapping("/employee/{email}")
    public @ResponseBody
    ResponseEntity<Employee> getEmployeeDetail(@PathVariable String email){
        int id = employeeRepository.findByEmail(email).getId();
        Employee employee = employeeRepository.findById(id);
        return ResponseEntity.ok(employee);
    }

    @CrossOrigin
    @PostMapping("/employee")
    public @ResponseBody
    ResponseEntity updateEmployee(@RequestBody Employee employee) {
        List<Contact> contactList = employee.getContactList();
        for(Contact c : contactList){
            c.setEmployee(employee);
        }
        VisaStatus vs = employee.getVisaStatus();
        vs.setEmployee(employee);

        Address address = employee.getAddress();
        address.setEmployee(employee);
        employeeRepository.save(employee);
        return ResponseEntity.ok("");
    }

    @PostMapping("/address")
    public @ResponseBody
    ResponseEntity updateAddress(@RequestBody Address address) {
        addressService.update(address);
        return ResponseEntity.ok("");
    }
}
