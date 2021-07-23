package com.example.hrteamproject.Controller;


import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Dao.RegistrationTokenRepository;
import com.example.hrteamproject.Dao.UserRepository;
import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.RegistrationToken;
import com.example.hrteamproject.Pojo.User;
import com.example.hrteamproject.Pojo.response.ErrorResponse;
import com.example.hrteamproject.Pojo.response.GeneralResponse;
import com.example.hrteamproject.Server.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping()
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RegistrationTokenRepository registrationTokenRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmailService emailService;

    @CrossOrigin
    @PostMapping("/token")
    public @ResponseBody ResponseEntity<GeneralResponse> createToken(@RequestBody RegistrationToken registrationToken1) {
        String email = registrationToken1.getEmail();
        String token = UUID.randomUUID().toString();
        RegistrationToken registrationToken = registrationTokenRepository.findByEmail(email);

        if(registrationToken == null) {
            registrationToken = new RegistrationToken(token, getValidDuration(), email, "");
        } else {
            registrationToken.setToken(token);
            registrationToken.setValidDuration(getValidDuration());
        }
        registrationTokenRepository.save(registrationToken);
        emailService.sendSimpleMessage(email,"token",token);
        return ResponseEntity.ok(new GeneralResponse(registrationToken.getEmail()));
    }

    @CrossOrigin
    @PostMapping("/register")
    public void createAccount(@RequestBody Employee employee, HttpServletResponse response) throws IOException {
        Employee curUser = employeeRepository.findByEmail(employee.getEmail());
        GeneralResponse generalResponse = new GeneralResponse();
        if(curUser == null) {
            employeeRepository.save(employee);
        } else {
            response.sendError(403,"email address already been used");
        }
    }
    @CrossOrigin
    @PostMapping("/checkToken")
    public @ResponseBody ResponseEntity<GeneralResponse> checkToken(@RequestBody RegistrationToken registrationToken1) {
        String token = registrationToken1.getToken();
        RegistrationToken registrationToken = registrationTokenRepository.findByToken(token);
        if(registrationToken == null || registrationToken.getValidDuration().compareTo(getCurrentTime()) < 0) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
        // 前端可以从body里的message这个属性里get到email，把username，password 还有email 包起来后再发到后端。
        return ResponseEntity.ok(new GeneralResponse(registrationToken.getEmail()));
    }
    @CrossOrigin
    @PostMapping("/checkUserName")
    public @ResponseBody ResponseEntity<GeneralResponse> checkUserName(@RequestBody User user) {
        User user1 = userRepository.findByUserName(user.getUserName());
        if(user1 != null) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
        userRepository.save(user);
        return ResponseEntity.ok(new GeneralResponse("true"));
    }

    private String getValidDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Calendar ca=Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(Calendar.HOUR_OF_DAY, 3);
        return sdf.format(ca.getTime());
    }

    private String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return sdf.format(date);

    }
//    @PostMapping("/checkUserName")
//    public @ResponseBody ResponseEntity<GeneralResponse> checkUserName(@RequestBody User user) {
//        User user1 = userRepository.findByUserName(user.getUserName());
//        if(user1 != null) return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "false"), HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok(new GeneralResponse("true"));
//    }
}
