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
    private BusService servicioBus;

	@GetMapping("/listar")
	public List<Bus> lista(){
		return servicioBus.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Bus> obtenerPorId(@PathVariable Integer id) {
        Bus bus = servicioBus.findById(id);
        return ResponseEntity.ok(bus);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Bus> registrar(@RequestBody Bus bus) {
        Bus nuevoBus = servicioBus.registrar(bus);
        return ResponseEntity.status(201).body(nuevoBus); // Código 201: Creado
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Bus> actualizar(@PathVariable Integer id, @RequestBody Bus bus) {
    	Bus busActualizado = servicioBus.actualizar(id, bus);
    	return ResponseEntity.ok(busActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	servicioBus.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
