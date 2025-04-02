package com.example.Prova.controller;

import com.example.Prova.model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {

    private List<Pessoa> pessoas = new ArrayList<>();

    // Endpoint para adicionar uma pessoa
    @PostMapping("/addPessoa")
    public String addPessoa(@RequestBody Pessoa pessoa) {
        pessoas.add(pessoa);
        return "Pessoa adicionada com sucesso!";
    }

    // Endpoint para listar todas as pessoas
    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
