package com.proyecto.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.transporte.entidad.Personal;
import com.proyecto.transporte.service.PersonalService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/listar")
    public List<Personal> listar() {
        return personalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personalService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Personal> registrar(@RequestBody Personal personal) {
        return ResponseEntity.status(201).body(personalService.registrar(personal));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Personal> actualizar(@PathVariable Long id, @RequestBody Personal personal) {
        return ResponseEntity.ok(personalService.actualizar(id, personal));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
