package com.company;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int poupanca_ID, String poupanca_nome, float poupanca_saldo, boolean poupanca_ativa){
        this.conta_ID = poupanca_ID;
        this.conta_nome = poupanca_nome;
        this.conta_saldo = poupanca_saldo;
        this.conta_ativa = poupanca_ativa;
        this.conta_tipo = "poupanca";
    }
}
