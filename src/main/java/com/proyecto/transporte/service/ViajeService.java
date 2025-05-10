package com.proyecto.transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.transporte.dao.ViajeRepository;
import com.proyecto.transporte.entidad.Bus;
import com.proyecto.transporte.entidad.Viaje;

@Service
public class ViajeService {
	@Autowired
    private ViajeRepository repo;
	
	public List<Viaje> listarTodos() {
        return repo.findAll();
    }

    public Viaje registrar(Viaje v) {
        return repo.save(v);
    }

    public Viaje findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
    }
    
    public Viaje actualizar(Integer id, Viaje viajeActualizado) {
    	Viaje v = repo.findById(id).orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        v.setFechaSalida(viajeActualizado.getFechaSalida());
        v.setFechaLlegada(viajeActualizado.getFechaLlegada());
        v.setIncidencias(viajeActualizado.getIncidencias());
        v.setPrecio(viajeActualizado.getPrecio());
        v.setDestino(viajeActualizado.getDestino());
        v.setBus(viajeActualizado.getBus());
        return repo.save(v);
    }

    public void eliminar(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Viaje no encontrado");
        }
    }
}
