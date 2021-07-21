package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.RegistrationToken;
import com.example.hrteamproject.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationTokenRepository extends CrudRepository<RegistrationToken,String> {
    RegistrationToken findByToken(String token);
    RegistrationToken findByEmail(String email);

}
