package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,String> {
}
