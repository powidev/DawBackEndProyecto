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

    public Bus registrar(Bus b) {
        return repo.save(b);
    }

    public Bus findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Bus no encontrado"));
    }

    public Bus actualizar(Integer id, Bus busActualizado) {
        Bus bus = repo.findById(id).orElseThrow(() -> new RuntimeException("Bus no encontrado"));
        bus.setModelo(busActualizado.getModelo());
        bus.setMarca(busActualizado.getMarca());
        bus.setAnio(busActualizado.getAnio());
        bus.setCapacidad(busActualizado.getCapacidad());
        bus.setPlaca(busActualizado.getPlaca());
        return repo.save(bus);
    }

    public void eliminar(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Bus no encontrado");
        }
    }
}

