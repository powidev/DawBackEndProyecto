package com.proyecto.transporte.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.transporte.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
}
