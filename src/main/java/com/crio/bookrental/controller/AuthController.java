package com.crio.bookrental.controller;

import com.crio.bookrental.dto.AuthRequestDTO;
import com.crio.bookrental.dto.RegisterRequestDTO;
import com.crio.bookrental.dto.ResponseDTO;
import com.crio.bookrental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @author adityagupta
 * @date 05/04/24
 */
@RestController
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(
            @RequestBody AuthRequestDTO request
            ){
        return ResponseEntity.ok(authService.login(request));
    }
}
