package com.limamed.bra.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime datanascimento;
    private String CEP;


}
