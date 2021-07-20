package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.RegistrationToken;
import com.example.hrteamproject.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationTokenRepository extends JpaRepository<RegistrationTokenRepository,String> {
    RegistrationToken findByToken(String token);
}
