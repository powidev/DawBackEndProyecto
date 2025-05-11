package com.proyecto.transporte.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.transporte.dao.DetalleVentaRepository;
import com.proyecto.transporte.entidad.DetalleVentaPasaje;

@Service
public class DetalleVentaService {
	@Autowired
	private DetalleVentaRepository detalleRepo;
	
	public List<DetalleVentaPasaje> listarTodos() {
        return detalleRepo.findAll();
    }

    public DetalleVentaPasaje registrar(DetalleVentaPasaje detalle) {
        return detalleRepo.save(detalle);
    }

    public DetalleVentaPasaje buscarPorId(Long id) {
        return detalleRepo.findById(id).orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
    }

    public DetalleVentaPasaje actualizar(Long id, DetalleVentaPasaje detalleActualizado) {
        DetalleVentaPasaje detalle = detalleRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));

        detalle.setVentaPasaje(detalleActualizado.getVentaPasaje());
        detalle.setViaje(detalleActualizado.getViaje());
        detalle.setPrecio(detalleActualizado.getPrecio());
        detalle.setCantidad(detalleActualizado.getCantidad());
        detalle.setTotal(detalleActualizado.getTotal());

        return detalleRepo.save(detalle);
    }

    public void eliminar(Long id) {
        if (detalleRepo.existsById(id)) {
        	detalleRepo.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de venta no encontrado");
        }
    }
}
