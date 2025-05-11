package com.proyecto.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.transporte.entidad.RevisionBus;
import com.proyecto.transporte.service.RevisionService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/revision")
public class RevisionController {

    @Autowired
    private RevisionService revisionService;

    @GetMapping("/listar")
    public List<RevisionBus> listar() {
        return revisionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevisionBus> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(revisionService.buscarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<RevisionBus> registrar(@RequestBody RevisionBus revision) {
        return ResponseEntity.status(201).body(revisionService.registrar(revision));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<RevisionBus> actualizar(@PathVariable Integer id, @RequestBody RevisionBus revision) {
        return ResponseEntity.ok(revisionService.actualizar(id, revision));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        revisionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
