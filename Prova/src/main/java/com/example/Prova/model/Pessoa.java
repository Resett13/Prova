package com.example.Prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotNull(message = "CPF é obrigatório.")
    @CPF(message = "CPF inválido. O formato esperado é 123.456.789-00.")
    private String cpf;

    @NotNull(message = "Idade é obrigatória.")
    private Integer idade;

    // Construtores, Getters e Setters
    public Pessoa(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // Ajuste a lógica para permitir idade nula
        if (this.idade != null && this.idade < 18) {
            throw new IllegalArgumentException("Apenas maiores de 18 anos podem trocar de nome.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; // Apenas atribui o valor, a validação será feita pelo @CPF
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
