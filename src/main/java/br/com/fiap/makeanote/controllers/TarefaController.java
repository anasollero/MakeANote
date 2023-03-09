package br.com.fiap.makeanote.controllers;

import br.com.fiap.makeanote.models.Tarefa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TarefaController {

    @GetMapping("/makeanote/api/usuario/tarefa")
    public Tarefa show() {
        return new Tarefa("Reunião Mensal", "Reunião mensal para discussoões sobre atualizações junto ao time.", LocalDate.now());
    }
}
