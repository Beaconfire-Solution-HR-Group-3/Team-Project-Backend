package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String> {
       User findById(int id);
       User findByEmail(String email);
       User findByUserName(String name);
}
