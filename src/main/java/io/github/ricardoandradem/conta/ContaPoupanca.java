package io.github.ricardoandradem.conta;

import io.github.ricardoandradem.Cliente;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int agencia, int conta, Cliente cliente) {
        super(agencia, conta, cliente);
    }

    public void aplicarRendimento(BigDecimal taxa) {
        super.setSaldo(
                super.getSaldo().add(super.getSaldo().multiply(taxa))
        );
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (super.getSaldo().subtract(valor).doubleValue() >= 0) {
            super.setSaldo(super.getSaldo().subtract(valor));
        } else {
            throw new RuntimeException("Não foi possivel sacar: Sem saldo");
        }
    }

    @Override
    public void transferir(BigDecimal valor, Conta contaDestino) {
       try {
           this.sacar(valor);
           contaDestino.depositar(valor);
       } catch (RuntimeException e) {
           throw new RuntimeException("Não foi possivel transferir: Sem saldo");
       }
    }

    @Override
    public String toString() {
        return "ContaPoupanca{}->" + super.toString();
    }
}
