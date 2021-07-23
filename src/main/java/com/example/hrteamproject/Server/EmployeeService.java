package com.example.hrteamproject.Server;

import com.example.hrteamproject.Pojo.Address;
import com.example.hrteamproject.Pojo.Employee;
import org.springframework.stereotype.Service;

//· Name — Legal Name(Full Name) · Preferred Name
//        · Avatar
//        · Date of Birth, Age, Gender
//        · SSN(Only Show Last Four Digits)
//· Contact Info Section
//        · Personal Email, Work Email · Cellphone, Work phone
@Service
public class EmployeeService {
    public void updateNameSection(Employee org, Employee employee) {
        org.setFirstName(employee.getFirstName());
        org.setLastName(employee.getLastName());
        org.setPreferedName(employee.getPreferedName());
        org.setSsn(employee.getSsn());
        org.setGender(employee.getGender());
        org.setAvartar(employee.getAvartar());
        org.setEmail(employee.getEmail());
        org.setCellphone(employee.getCellphone());
    }

    public void updateAddress(Address org, Address address) {
        org.setAddressLine1(address.getAddressLine1());
        org.setCity(address.getCity());
        org.setStateName(address.getStateName());
        org.setZipcode(address.getZipcode());
    }

//    public void updateContactInfo(Employee org, Employee employee) {
//
//    }
}
