package com.limamed.bra.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column
    private String telefone;
    @Column
    private LocalDateTime datanascimento;
    @Column
    private String CEP;

}
