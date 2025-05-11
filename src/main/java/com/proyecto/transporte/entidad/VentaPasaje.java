package com.proyecto.transporte.entidad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "venta_pasaje")
public class VentaPasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "cliente", nullable = false, length = 100)
    private String cliente;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToMany(mappedBy = "ventaPasaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaPasaje> detalles = new ArrayList<>();
}