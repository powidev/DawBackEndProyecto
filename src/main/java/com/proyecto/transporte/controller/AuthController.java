package com.proyecto.transporte.controller;

import com.proyecto.transporte.service.IAuthService;
import com.proyecto.transporte.dto.login.LoginRequest;
import com.proyecto.transporte.dto.login.LoginResponse;
import com.proyecto.transporte.dto.registrar.RegistrarRequestDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = service.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegistrarRequestDTO request) {
        service.register(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
