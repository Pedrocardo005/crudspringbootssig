package com.example.crud.repository;

import java.util.ArrayList;

import com.example.crud.models.Pessoa;

import org.springframework.stereotype.Repository;

@Repository
@Deprecated
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

    public Pessoa findByCpf(String cpf) {
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }

        return null;
    }

    public Pessoa update(Pessoa pessoa){
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            if(p.getCpf().equals(pessoa.getCpf())) {
                pessoas.remove(i);
                pessoas.add(pessoa);
                return pessoa;
            }
        }

        return null;
    }
}
