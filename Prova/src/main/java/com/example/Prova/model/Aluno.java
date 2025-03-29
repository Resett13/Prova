package com.example.Prova.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class Aluno {
    @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

public Aluno (String nome, int idade){
    this.nome = nome;
    this.idade = idade;

}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
