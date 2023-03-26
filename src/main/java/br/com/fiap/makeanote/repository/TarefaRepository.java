package br.com.fiap.makeanote.repository;

import br.com.fiap.makeanote.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    
}
