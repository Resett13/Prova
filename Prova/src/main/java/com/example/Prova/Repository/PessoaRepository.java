package com.example.Prova.Repository;

import com.example.Prova.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
