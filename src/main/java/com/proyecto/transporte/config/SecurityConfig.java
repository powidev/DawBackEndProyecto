package com.proyecto.transporte.config;

import com.proyecto.transporte.service.UsuarioDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http 
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/","/publico").permitAll()
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
			)
			.formLogin(form -> form.loginPage("/login").permitAll())
			.logout(logout -> logout.permitAll());
		
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Necesario si usas AuthenticationManager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration
	config) throws Exception{
		return config.getAuthenticationManager();
	}
}
