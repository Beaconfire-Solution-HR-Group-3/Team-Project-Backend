package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {
    Address findById(int id);
}
