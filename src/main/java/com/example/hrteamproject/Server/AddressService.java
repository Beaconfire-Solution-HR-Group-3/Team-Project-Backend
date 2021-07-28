package com.example.hrteamproject.Server;


import com.example.hrteamproject.Dao.AddressRepository;
import com.example.hrteamproject.Pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;


    public void update(Address address) {
        Address address1 = addressRepository.findById(address.getId());
        address1.setAddressLine1(address.getAddressLine1());
        address1.setCity(address.getCity());
        address1.setStateName(address.getStateName());
        address1.setZipcode(address.getZipcode());
    }
}
