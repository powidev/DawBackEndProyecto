package com.proyecto.transporte.service.Impl;

import com.proyecto.transporte.entidad.Usuario;
import com.proyecto.transporte.dao.IUsuarioRepository;
import com.proyecto.transporte.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUsuarioRepository usuarioRepository;

    @Override
    public Usuario getUserByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
