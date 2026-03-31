package com.limamed.bra.controllers;

import com.limamed.bra.dtos.PacienteDto;
import com.limamed.bra.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    //Cadastrar Usuario
    @PostMapping("/usuario")
    public String cadastrar(PacienteDto dados){



        return "quero dormir";
    }



    //Edita Usuario

    //Lista Usuario

    //Excluir Usuario

}
