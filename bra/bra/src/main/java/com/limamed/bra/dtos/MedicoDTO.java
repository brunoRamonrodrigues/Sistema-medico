package com.limamed.bra.dtos;

import com.limamed.bra.models.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nome;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime datanascimento;
    private String telefone;
    private Especialidade especialidade;




}
