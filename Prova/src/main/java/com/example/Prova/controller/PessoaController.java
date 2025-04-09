package com.example.Prova.controller;

import com.example.Prova.model.Aluno;
import com.example.Prova.model.Professor;
import com.example.Prova.Repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Endpoint para adicionar um aluno
    @PostMapping("/addAluno")
    public Aluno addAluno(@Valid @RequestBody Aluno aluno) {
        return pessoaRepository.save(aluno);  // Salva no banco de dados e retorna o aluno
    }

    // Endpoint para adicionar  professor
    @PostMapping("/addProfessor")
    public Professor addProfessor(@Valid @RequestBody Professor professor) {
        return pessoaRepository.save(professor);  // Salva no banco de dados e retorna o professor
    }

    // Endpoint dos alunos
    @GetMapping("/alunos")
    public List<Aluno> getAlunos() {
        return pessoaRepository.findAll().stream()
                .filter(p -> p instanceof Aluno)
                .map(p -> (Aluno) p)
                .collect(Collectors.toList());
    }

    // Endpoint para listar apenas os Professores
    @GetMapping("/professores")
    public List<Professor> getProfessores() {
        return pessoaRepository.findAll().stream()
                .filter(p -> p instanceof Professor)
                .map(p -> (Professor) p)
                .collect(Collectors.toList());
    }
}
