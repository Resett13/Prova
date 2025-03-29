package com.example.Prova.controller;

import com.example.Prova.model.Aluno;
import com.example.Prova.model.Professor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/aluno")
@Validated // Habilita a validação
public class AlunoController {

    @GetMapping("/getAluno") 
    public Aluno getAluno() {
        // Para testar, use um nome válido (não vazio)
        return new Aluno("", 20); // Agora com um nome válido
    }

    @GetMapping("/getProfessor") 
    public Professor getProfessor() {
        return new Professor("Professor", 30, "123.456.789-00"); // CPF válido
    }
}
