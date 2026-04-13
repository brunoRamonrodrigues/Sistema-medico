package com.limamed.bra.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PacienteModel paciente;
    @ManyToOne
    private MedicoModel medico;
    @Column
    private LocalDate data;
    @Column
    private LocalTime hora;


}
