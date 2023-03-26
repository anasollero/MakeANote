package br.com.fiap.makeanote.controllers;


import br.com.fiap.makeanote.models.Conta;
import br.com.fiap.makeanote.repository.ContaRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/makeanote/api/usuario/conta")
public class ContaController {

    Logger log = LoggerFactory.getLogger(ContaController.class);

    @Autowired
    ContaRepository repository;

    @GetMapping
    public List<Conta> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Conta conta){
        log.info("cadastrando conta " + conta);
        repository.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        log.info("detalhando conta " + id);
        var contaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "conta não encontrada"));

        return ResponseEntity.ok(contaEncontrada);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Conta> destroy(@PathVariable Long id){
        log.info("apagando conta " + id);
        var contaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao apagar. Conta não encontrada"));

        repository.delete(contaEncontrada);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody @Valid Conta conta){
        log.info("atualizando conta " + id);
        repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "conta não encontrada"));

        conta.setId(id);
        repository.save(conta);

        return ResponseEntity.ok(conta);
    }
    
}