package com.proyecto.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.transporte.entidad.VentaPasaje;
import com.proyecto.transporte.service.VentaService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/venta")
public class VentaPasajeController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/listar")
    public List<VentaPasaje> listar() {
        return ventaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaPasaje> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<VentaPasaje> registrar(@RequestBody VentaPasaje venta) {
        return ResponseEntity.status(201).body(ventaService.registrar(venta));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<VentaPasaje> actualizar(@PathVariable Long id, @RequestBody VentaPasaje venta) {
        return ResponseEntity.ok(ventaService.actualizar(id, venta));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
