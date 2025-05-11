package com.proyecto.transporte.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personal")
public class Personal {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nombre;
    private String apellido;
    private String dni;
    private String cargo;
    private String telefono;

    // Relación inversa con RevisionBus
    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RevisionBus> revisionBuses;

}
