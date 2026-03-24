package com.limamed.bra.controllers;

import com.limamed.bra.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    //Cadastrar Usuario
    @PostMapping("/usuario")
    public String cadastrar(){
        return "quero dormir";
    }



    //Edita Usuario

    //Lista Usuario

    //Excluir Usuario

}
