package com.proyecto.transporte.entidad;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "viaje")
public class Viaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viaje")
    private Integer idViaje;

	@ManyToOne
	@JoinColumn(name = "id_bus", nullable = false)
	@JsonIgnoreProperties("viajes")
	private Bus bus;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    @JsonIgnoreProperties("viajes")
    private Destino destino;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "fech_sal", nullable = false)
    private LocalDateTime fechaSalida;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "fech_lle", nullable = false)
    private LocalDateTime fechaLlegada;

    @Column(name = "incidencias", length = 40)
    private String incidencias;

    @Column(name = "precio", nullable = false)
    private double precio;
}
