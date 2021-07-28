package com.example.hrteamproject.Server;

import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Pojo.Address;
import com.example.hrteamproject.Pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//· Name — Legal Name(Full Name) · Preferred Name
//        · Avatar
//        · Date of Birth, Age, Gender
//        · SSN(Only Show Last Four Digits)
//· Contact Info Section
//        · Personal Email, Work Email · Cellphone, Work phone
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void updateNameSection(Employee employee) {
        Employee employee1 = employeeRepository.findById(employee.getId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setPreferedName(employee.getPreferedName());
        employee1.setSsn(employee.getSsn());
        employee1.setGender(employee.getGender());
        employee1.setAvartar(employee.getAvartar());
        employee1.setEmail(employee.getEmail());
        employee1.setCellphone(employee.getCellphone());
    }

//    public void updateContactInfo(Employee org, Employee employee) {
//
//    }
}
