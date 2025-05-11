package com.proyecto.transporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.transporte.dao.RevisionBusRepository;
import com.proyecto.transporte.entidad.RevisionBus;

@Service
public class RevisionService {

    @Autowired
    private RevisionBusRepository revisionRepo;

    public List<RevisionBus> listarTodos() {
        return revisionRepo.findAll();
    }

    public RevisionBus registrar(RevisionBus revision) {
        return revisionRepo.save(revision);
    }

    public RevisionBus buscarPorId(Integer id) {
        return revisionRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Revisión no encontrada"));
    }

    public RevisionBus actualizar(Integer id, RevisionBus revisionActualizada) {
        RevisionBus revision = revisionRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Revisión no encontrada"));

        revision.setFechaRevision(revisionActualizada.getFechaRevision());
        revision.setTipoRevision(revisionActualizada.getTipoRevision());
        revision.setResultado(revisionActualizada.getResultado());
        revision.setObservaciones(revisionActualizada.getObservaciones());
        revision.setBus(revisionActualizada.getBus());
        revision.setPersonal(revisionActualizada.getPersonal());

        return revisionRepo.save(revision);
    }

    public void eliminar(Integer id) {
        if (revisionRepo.existsById(id)) {
            revisionRepo.deleteById(id);
        } else {
            throw new RuntimeException("Revisión no encontrada");
        }
    }
}
