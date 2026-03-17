package com.limamed.bra.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoModel {
    private String nome;
    private String cpf;
    private String idade;
    private String telefone;
}
