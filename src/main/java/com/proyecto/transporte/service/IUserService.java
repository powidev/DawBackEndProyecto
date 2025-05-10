package com.proyecto.transporte.service;

import com.proyecto.transporte.entidad.Usuario;

public interface IUserService {
    Usuario getUserByUsername(String username);
}
