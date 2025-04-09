package com.example.Prova.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PessoaTest {

    private final Validator validator;

    public PessoaTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    void testValidPessoa() {
        Pessoa pessoa = new Pessoa("João Silva", "123.456.789-09", 25);
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
        assertTrue(violations.isEmpty(), "Pessoa válida não deve gerar violações.");
    }

    @Test
    void testInvalidCPF() {
        Pessoa pessoa = new Pessoa("João Silva", "123.456.789-00", 25);
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
        assertFalse(violations.isEmpty(), "CPF inválido deve gerar violações.");
    }

    @Test
    void testBlankName() {
        Pessoa pessoa = new Pessoa("", "123.456.789-09", 25);
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
        assertFalse(violations.isEmpty(), "Nome em branco deve gerar violações.");
    }

    @Test
    void testNullIdade() {
        Pessoa pessoa = new Pessoa("João Silva", "123.456.789-09", null);
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
        assertFalse(violations.isEmpty(), "Idade nula deve gerar violações.");
        assertEquals("Idade é obrigatória.", violations.iterator().next().getMessage());
    }

    @Test
    void testChangeNameUnder18() {
        Pessoa pessoa = new Pessoa("João Silva", "123.456.789-09", 17);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> pessoa.setNome("Carlos"));
        assertEquals("Apenas maiores de 18 anos podem trocar de nome.", exception.getMessage());
    }

    @Test
    void testChangeNameOver18() {
        Pessoa pessoa = new Pessoa("João Silva", "123.456.789-09", 25);
        pessoa.setNome("Carlos");
        assertEquals("Carlos", pessoa.getNome(), "Nome deve ser alterado para maiores de 18 anos.");
    }
}
