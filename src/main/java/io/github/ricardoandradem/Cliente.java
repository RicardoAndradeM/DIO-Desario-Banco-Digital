package io.github.ricardoandradem;

public record Cliente(String nome, String sobrenome, String cpf){
    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }
}
