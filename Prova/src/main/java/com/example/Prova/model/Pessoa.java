package com.example.Prova.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Pessoa {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotNull
    private Integer idade; // Agora aceitamos a idade diretamente

    // Construtores, Getters e Setters
    public Pessoa(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // Verifica se a pessoa tem 18 anos ou mais antes de alterar o nome
        if (this.idade >= 18) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Não pode alterar o nome. Menor de 18 anos.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }
}
