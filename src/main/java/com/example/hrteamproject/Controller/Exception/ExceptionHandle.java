package com.example.hrteamproject.Controller.Exception;


import com.example.hrteamproject.Pojo.response.ErrorResponse;
import com.example.hrteamproject.Pojo.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping
public class ExceptionHandle {

    @GetMapping("/notLoginHandler")
    @CrossOrigin
    public ResponseEntity<GeneralResponse> login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam("redirect") String url) throws IOException {
        GeneralResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,url);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
