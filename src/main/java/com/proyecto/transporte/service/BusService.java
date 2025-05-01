package com.proyecto.transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.transporte.dao.BusRepository;
import com.proyecto.transporte.entidad.Bus;

@Service
public class BusService {

    @Autowired
    private BusRepository repo;

    public List<Bus> listarTodos() {
        return repo.findAll();
    }

    public Bus registrar(Bus bus) {
        return repo.save(bus);
    }

    public Bus findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Bus no encontrado"));
    }

    public Bus actualizar(Long id, Bus busActualizado) {
        Bus bus = repo.findById(id).orElseThrow(() -> new RuntimeException("Bus no encontrado"));
        bus.setModelo(busActualizado.getModelo());
        bus.setMarca(busActualizado.getMarca());
        bus.setAnio(busActualizado.getAnio());
        bus.setCapacidad(busActualizado.getCapacidad());
        bus.setPlaca(busActualizado.getPlaca());
        bus.setViajes(busActualizado.getViajes());
        return repo.save(bus);
    }

    public void eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Bus no encontrado");
        }
    }
}

