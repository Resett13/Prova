package com.example.Prova.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prova.Repository.PessoaRepository;
import com.example.Prova.model.Pessoa;

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
        if (pessoa.getIdade() != null && pessoa.getIdade() < 18) {
            throw new IllegalArgumentException("Apenas maiores de 18 anos podem trocar de nome.");
        }
        return pessoaRepository.save(pessoa);  // Salva a pessoa no banco de dados
    }
}
