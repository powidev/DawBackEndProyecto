package com.proyecto.transporte.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bus")
public class Bus {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bus")
    private Integer idBus;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "placa", nullable = false, length = 20)
    private String placa;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("bus")
    @JsonIgnore
    private List<Viaje> viajes;
}
