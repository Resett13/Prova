package com.example.Prova.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Aluno extends Pessoa {
    // Construtor vazio para o JPA
    public Aluno() {}

    // Construtor específico para Aluno
    public Aluno(@NotBlank(message = "Nome é obrigatório.") String nome, String cpf, Integer idade) {
        super(nome, cpf, idade);
    }
}
