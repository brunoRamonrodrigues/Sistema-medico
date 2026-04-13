package com.limamed.bra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoController {

    @GetMapping("/agendamento")
    public String home() {
        return "agendamento";
    }
}