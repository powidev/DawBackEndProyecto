package com.proyecto.transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.transporte.dao.VentaPasajeRepository;
import com.proyecto.transporte.entidad.VentaPasaje;

@Service
public class VentaService {

    @Autowired
    private VentaPasajeRepository ventaRepo;

    public List<VentaPasaje> listarTodos() {
        return ventaRepo.findAll();
    }

    public VentaPasaje registrar(VentaPasaje venta) {
        return ventaRepo.save(venta);
    }

    public VentaPasaje buscarPorId(Long id) {
        return ventaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    public VentaPasaje actualizar(Long id, VentaPasaje ventaActualizada) {
        VentaPasaje venta = ventaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        venta.setFechaVenta(ventaActualizada.getFechaVenta());
        venta.setCliente(ventaActualizada.getCliente());
        venta.setTotal(ventaActualizada.getTotal());
        venta.setDetalles(ventaActualizada.getDetalles()); // cuidado con cómo gestionas esta lista

        return ventaRepo.save(venta);
    }

    public void eliminar(Long id) {
        if (ventaRepo.existsById(id)) {
            ventaRepo.deleteById(id);
        } else {
            throw new RuntimeException("Venta no encontrada");
        }
    }
}
