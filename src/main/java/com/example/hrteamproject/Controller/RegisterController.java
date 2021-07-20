package com.example.hrteamproject.Controller;


import com.example.hrteamproject.Dao.RegistrationTokenRepository;
import com.example.hrteamproject.Dao.UserRepository;
import com.example.hrteamproject.Pojo.RegistrationToken;
import com.example.hrteamproject.Pojo.User;
import com.example.hrteamproject.Pojo.response.ErrorResponse;
import com.example.hrteamproject.Pojo.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping()
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RegistrationTokenRepository registrationTokenRepository;

    @PostMapping("/register")
    public void createAccount(@RequestBody User user, HttpServletResponse response) throws IOException {
        User curUser = userRepository.findByEmail(user.getEmail());
        GeneralResponse generalResponse = new GeneralResponse();
        if(curUser == null) {
            userRepository.save(user);
        } else {
            response.sendError(403,"email address already been used");
        }
    }

    @PostMapping("/checkToken")
    public @ResponseBody ResponseEntity<GeneralResponse> checkToken(HttpServletRequest request) {
        String token = (String)request.getAttribute("token");
        RegistrationToken registrationToken = registrationTokenRepository.findByToken(token);
        if(registrationToken == null) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
        // 前端可以从body里的message这个属性里get到email，把username，password 还有email 包起来后再发到后端。
        return ResponseEntity.ok(new GeneralResponse(registrationToken.getEmail()));
    }

    @PostMapping("/checkUserName")
    public @ResponseBody ResponseEntity<GeneralResponse> checkUserName(@RequestBody User user) {
        User user1 = userRepository.findByUserName(user.getUserName());
        if(user1 != null) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
        userRepository.save(user);
        return ResponseEntity.ok(new GeneralResponse("true"));
    }
//    @PostMapping("/checkUserName")
//    public @ResponseBody ResponseEntity<GeneralResponse> checkUserName(@RequestBody User user) {
//        User user1 = userRepository.findByUserName(user.getUserName());
//        if(user1 != null) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok(new GeneralResponse("true"));
//    }
}
