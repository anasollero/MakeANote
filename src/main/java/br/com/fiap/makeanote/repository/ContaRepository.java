package br.com.fiap.makeanote.repository;

import br.com.fiap.makeanote.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    
}
