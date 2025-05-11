package com.proyecto.transporte.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "detalle_venta_pasaje")
public class DetalleVentaPasaje {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idDetalle;

	    @ManyToOne
	    @JoinColumn(name = "id_venta")
	    private VentaPasaje ventaPasaje;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_viaje", nullable = false)
	    private Viaje viaje;

	    @Column(name = "precio", nullable = false)
	    private double precio;

	    @Column(name = "cantidad", nullable = false)
	    private int cantidad;

	    @Column(name = "total", nullable = false)
	    private double total;
}
