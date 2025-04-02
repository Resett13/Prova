package com.example.Prova.Service;

import com.example.Prova.model.Pessoa;
import com.example.Prova.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;  // Injeta o repositório de Pessoa

    // Método para listar todas as pessoas
    public Iterable<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();  // Retorna todas as pessoas do banco de dados
    }

    // Método para salvar uma pessoa
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);  // Salva a pessoa no banco de dados
    }
}
