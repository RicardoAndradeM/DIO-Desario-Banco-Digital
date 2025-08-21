package io.github.ricardoandradem.conta;

import io.github.ricardoandradem.Cliente;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{

    private BigDecimal limite;

    public ContaCorrente(int agencia, int conta, Cliente cliente, BigDecimal limite) {
        super(agencia, conta, cliente);
        this.limite = limite;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (super.getSaldo().add(this.limite).subtract(valor).doubleValue() >= 0) {
            super.setSaldo(super.getSaldo().subtract(valor));
        } else {
            throw new RuntimeException("Não foi possivel sacar: Sem saldo e limite");
        }
    }

    @Override
    public void transferir(BigDecimal valor, Conta contaDestino) {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possivel transferir: Sem saldo e limite");
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "}->" + super.toString();
    }
}
