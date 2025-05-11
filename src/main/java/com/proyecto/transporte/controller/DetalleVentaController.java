package com.proyecto.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.transporte.entidad.DetalleVentaPasaje;
import com.proyecto.transporte.service.DetalleVentaService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleService;

    @GetMapping("/listar")
    public List<DetalleVentaPasaje> listar() {
        return detalleService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaPasaje> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<DetalleVentaPasaje> registrar(@RequestBody DetalleVentaPasaje detalle) {
        return ResponseEntity.status(201).body(detalleService.registrar(detalle));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DetalleVentaPasaje> actualizar(@PathVariable Long id, @RequestBody DetalleVentaPasaje detalle) {
        return ResponseEntity.ok(detalleService.actualizar(id, detalle));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
