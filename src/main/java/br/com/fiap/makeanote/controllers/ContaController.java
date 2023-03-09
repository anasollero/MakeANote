package br.com.fiap.makeanote.controllers;

import br.com.fiap.makeanote.models.Conta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @GetMapping("/makeanote/api/usuario/conta")
    public Conta show() {
        return new Conta("Luiz", "teste@gmail.com", "senha123");
    }
}
