package com.proyecto.transporte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.transporte.entidad.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer>{

}
