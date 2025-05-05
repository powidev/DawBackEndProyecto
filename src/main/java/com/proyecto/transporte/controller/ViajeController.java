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
import com.proyecto.transporte.entidad.Viaje;
import com.proyecto.transporte.service.ViajeService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/viaje")
public class ViajeController {
	@Autowired
    private ViajeService servicioViaje;
	
	@GetMapping("/listar")
	public List<Viaje> lista(){
		return servicioViaje.listarTodos();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Viaje> obtenerPorId(@PathVariable Integer id) {
		Viaje v = servicioViaje.findById(id);
        return ResponseEntity.ok(v);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Viaje> registrar(@RequestBody Viaje v) {
    	Viaje nuevoViaje = servicioViaje.registrar(v);
        return ResponseEntity.status(201).body(nuevoViaje);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Viaje> actualizar(@PathVariable Integer id, @RequestBody Viaje v) {
    	Viaje viajeActualizado = servicioViaje.actualizar(id, v);
    	return ResponseEntity.ok(viajeActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	servicioViaje.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
