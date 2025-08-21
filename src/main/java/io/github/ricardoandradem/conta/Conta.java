package io.github.ricardoandradem.conta;

import io.github.ricardoandradem.Cliente;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {
    private final int agencia;
    private final int numero;
    private final Cliente cliente;
    private BigDecimal saldo;

    public Conta(int agencia, int numero, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = new BigDecimal("0.0");
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta1 = (Conta) o;
        return agencia == conta1.agencia && numero == conta1.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + numero +
                ", cliente=" + cliente.getNomeCompleto() +
                ", saldo=" + saldo +
                '}';
    }

    public abstract void sacar(BigDecimal valor);
    public abstract void transferir(BigDecimal valor, Conta contaDestino);
}
