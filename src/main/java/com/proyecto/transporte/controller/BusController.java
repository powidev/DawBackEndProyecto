package com.proyecto.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.transporte.entidad.Bus;
import com.proyecto.transporte.service.BusService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/bus")
public class BusController {
	@Autowired
    private BusService busService;

	@GetMapping("/listar")
    public ResponseEntity<List<Bus>> listarTodos() {
        List<Bus> buses = busService.listarTodos();
        return ResponseEntity.ok(buses);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Bus> obtenerPorId(@PathVariable Long id) {
        Bus bus = busService.findById(id);
        return ResponseEntity.ok(bus);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Bus> registrar(@RequestBody Bus bus) {
        Bus nuevoBus = busService.registrar(bus);
        return ResponseEntity.status(201).body(nuevoBus); // Código 201: Creado
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Bus> actualizar(@PathVariable Long id, @RequestBody Bus busActualizado) {
        Bus bus = busService.actualizar(id, busActualizado);
        return ResponseEntity.ok(bus);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        busService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
