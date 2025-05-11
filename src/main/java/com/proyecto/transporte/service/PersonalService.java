package com.proyecto.transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.transporte.dao.PersonalRepository;
import com.proyecto.transporte.entidad.Personal;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepo;

    public List<Personal> listarTodos() {
        return personalRepo.findAll();
    }

    public Personal registrar(Personal personal) {
        return personalRepo.save(personal);
    }

    public Personal buscarPorId(Long id) {
        return personalRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Personal no encontrado"));
    }

    public Personal actualizar(Long id, Personal personalActualizado) {
        Personal personal = personalRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Personal no encontrado"));

        personal.setNombre(personalActualizado.getNombre());
        personal.setApellido(personalActualizado.getApellido());
        personal.setDni(personalActualizado.getDni());
        personal.setCargo(personalActualizado.getCargo());
        personal.setTelefono(personalActualizado.getTelefono());

        return personalRepo.save(personal);
    }

    public void eliminar(Long id) {
        if (personalRepo.existsById(id)) {
            personalRepo.deleteById(id);
        } else {
            throw new RuntimeException("Personal no encontrado");
        }
    }
}
