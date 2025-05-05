package com.proyecto.transporte.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.*; 
import org.springframework.security.core.authority.SimpleGrantedAuthority; 
import org.springframework.stereotype.Service;
import com.proyecto.transporte.dao.UsuarioRepository;
import com.proyecto.transporte.entidad.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
		
		return new org.springframework.security.core.userdetails.User(
				usuario.getUsername(),
				usuario.getPassword(),
				usuario.getRoles().stream()
						.map(rol -> new SimpleGrantedAuthority("ROLE_" + 
	rol.getNombre()))
						.collect(Collectors.toList())
		);
	}
}
