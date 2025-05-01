package com.proyecto.transporte.entidad;

import java.util.List;
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
    private Long idBus;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "placa", nullable = false, length = 20)
    private String placa;

    @OneToMany(mappedBy = "idBus", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("idBus")
    private List<Viaje> viajes;
}
