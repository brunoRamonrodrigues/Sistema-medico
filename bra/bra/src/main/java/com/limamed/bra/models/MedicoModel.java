package com.limamed.bra.models;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column
    private LocalDateTime datanascimento;

    @Column
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
}
