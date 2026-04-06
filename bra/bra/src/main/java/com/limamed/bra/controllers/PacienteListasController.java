package com.limamed.bra.controllers;

import com.limamed.bra.dtos.PacienteDto;
import com.limamed.bra.dtos.UsuarioDto;
import com.limamed.bra.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PacienteListasController {

    private PacienteService pacienteService;

    public PacienteListasController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientelista")
    public String viewPacienteLista(Model model){

        List<PacienteDto> listaDto = pacienteService.listaPacientes();

        model.addAttribute(listaDto);

        return "pacientelista";
    }

    @GetMapping("/usuario/{id}")
    public String viewPaciente(@PathVariable Long id, Model model){

        PacienteDto pacienteDto = pacienteService.listaPaciente(id);

        model.addAttribute("pacienteDto", pacienteDto);

        return "pacienteatualizar";
    }

    @GetMapping("/pacientecadastro")
    public String viewCadastrar(Model model){
        model.addAttribute("pacienteDto", new PacienteDto());

        return "pacienteDto";
    }

}
