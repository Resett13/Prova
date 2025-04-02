package com.example.Prova.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  // Marca a classe como uma entidade JPA
@DiscriminatorValue("PROFESSOR")  // A coluna "tipo" no banco de dados vai ter o valor "PROFESSOR" para indicar que é um Professor
public class Professor extends Pessoa {

    private String departamento;  // Campo específico para a classe Professor

    // Construtor
    public Professor(String nome, Integer idade, String cpf, String departamento) {
        super(nome,cpf,idade);  // Chama o construtor da classe Pessoa (superclasse)
        this.departamento = departamento;  // Inicializa o campo específico da classe Professor
    }

    // Getters e Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
