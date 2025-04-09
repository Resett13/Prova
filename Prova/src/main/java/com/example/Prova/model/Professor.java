package com.example.Prova.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Professor extends Pessoa {
    private String departamento;

    // Construtor vazio para o JPA
    public Professor() {}

    // Construtor específico para Professor
    public Professor(@NotBlank(message = "Nome é obrigatório.") String nome, String cpf, Integer idade, String departamento) {
        super(nome, cpf, idade);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
