package io.github.ricardoandradem;

import io.github.ricardoandradem.conta.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String NomeDoBanco;
    private final ArrayList<Conta> contas;

    public Banco(String nomeDoBanco) {
        this.NomeDoBanco = nomeDoBanco;
        this.contas = new ArrayList<Conta>();
    }

    public String getNomeDoBanco() {
        return NomeDoBanco;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Conta> contasPorNome(String nome) {
        return contas.stream().filter(n -> n.getCliente().getNomeCompleto().equals(nome)).toList();
    }

    public Conta buscarConta(int agencia, int numero) {
        return contas.stream()
                .filter(n -> n.getAgencia() == agencia && n.getNumero() == numero)
                .toList()
                .getFirst();
    }
}
