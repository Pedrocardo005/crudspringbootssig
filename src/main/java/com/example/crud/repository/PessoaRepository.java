package com.example.crud.repository;

import java.util.ArrayList;

import com.example.crud.models.Pessoa;

import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {
    
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void cadastrarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> findAll() {
        return this.pessoas;
    }

    public void deletar(String cpf) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getCpf().equals(cpf)) {
                pessoas.remove(i);
            }
        }
    }
}
