package br.com.fiap.makeanote.controllers;

import br.com.fiap.makeanote.models.Tarefa;
import br.com.fiap.makeanote.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@RequestMapping("/makeanote/api/usuario/tarefa")
public class TarefaController {
    Logger log = LoggerFactory.getLogger(TarefaController.class);
    @Autowired
    TarefaRepository repository;
    @GetMapping
    public List<Tarefa> index(){
        return repository.findAll();
    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Tarefa tarefa){
        log.info("cadastrando tarefa " + tarefa);
        repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Object> show(@PathVariable Long id){
        log.info("detalhando tarefa " + id);
        var tarefaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));

        return ResponseEntity.ok(tarefaEncontrada);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destroy(@PathVariable Long id){
        log.info("apagando tarefa " + id);
        var tarefaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao apagar. Tarefa não encontrada"));

        repository.delete(tarefaEncontrada);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        log.info("atualizando tarefa " + id);
        repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));

        tarefa.setId(id);
        repository.save(tarefa);

        return ResponseEntity.ok(tarefa);
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
            }
        };
    }
    
}