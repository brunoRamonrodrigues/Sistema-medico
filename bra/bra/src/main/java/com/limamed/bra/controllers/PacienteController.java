package com.limamed.bra.controllers;

import com.limamed.bra.dtos.PacienteDto;
import com.limamed.bra.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    //Cadastrar Paciente
    @PostMapping("/paciente")
    public String cadastrar(@ModelAttribute("pacienteDto") PacienteDto dados, Model model){

        pacienteService.criarPaciente(dados);

        return "redirect:/pacientelista";
    }

    //Edita Paciente
    @PostMapping("/paciente/{id}")
    public String atualizar(@ModelAttribute("pacienteDto") PacienteDto dados, Model model, @PathVariable Long id){

        pacienteService.atualizarPaciente(id,dados);

        return "redirect:/pacientelista";
    }

    //Excluir Pacie         nte
    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        pacienteService.excluirPaciente(id);

        return ResponseEntity.ok(true);
    }

}
