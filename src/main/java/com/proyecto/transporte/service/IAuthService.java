package com.proyecto.transporte.service;

import com.proyecto.transporte.dto.login.LoginRequest;
import com.proyecto.transporte.dto.login.LoginResponse;
import com.proyecto.transporte.dto.registrar.RegistrarRequestDTO;

public interface IAuthService {
    LoginResponse authenticate(LoginRequest loginRequest);
    String register(RegistrarRequestDTO registerRequest);
}
