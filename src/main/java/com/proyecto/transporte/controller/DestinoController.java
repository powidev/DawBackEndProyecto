package com.proyecto.transporte.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.transporte.entidad.Destino;
import com.proyecto.transporte.service.DestinoService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/destino")
public class DestinoController {

    @Autowired
    private DestinoService servicioDes;

    @GetMapping("/listar")
    public List<Destino> listarTodos() {
        return servicioDes.listarTodos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Destino> registrar(
        @RequestParam("nombre") String nombre,
        @RequestParam(value = "imagen", required = false) MultipartFile imagen
    ) {
        try {
            Destino destino = servicioDes.guardarConImagen(nombre, imagen);
            return ResponseEntity.ok(destino);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Integer id) {
        Destino destino = servicioDes.findById(id);
        if (destino != null) {
            return ResponseEntity.ok(destino);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Destino> editar(
        @PathVariable Integer id,
        @RequestParam("nombre") String nombre,
        @RequestParam(value = "imagen", required = false) MultipartFile imagen
    ) {
        try {
            Destino destino = servicioDes.editarConImagen(id, nombre, imagen);
            return ResponseEntity.ok(destino);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            servicioDes.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
