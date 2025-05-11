package com.proyecto.transporte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.transporte.entidad.DetalleVentaPasaje;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaPasaje, Long>{

}
