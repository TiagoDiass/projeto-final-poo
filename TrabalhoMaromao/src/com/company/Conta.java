package com.company;

import java.util.ArrayList;

public class Conta {
    protected int conta_ID;
    protected String conta_nome;
    protected float conta_saldo;
    protected boolean conta_ativa;
    protected String conta_tipo;

    public String getConta_tipo() {
        return conta_tipo;
    }

    public void depositar(float valor_deposito){
        if(valor_deposito > 0){
            conta_saldo += valor_deposito;
            System.out.println(conta_nome + " agora possui R$: " + conta_saldo );
        }else{
            System.out.println("Valor inválido!");
        }
    }

    public void sacar(float valor_saque){
        if(valor_saque <= conta_saldo){
            conta_saldo -= valor_saque;
            System.out.println(conta_nome + " agora possui R$: " + conta_saldo );
        }
        else{
            System.out.println(conta_nome + " não possuí esse valor em sua conta!");
        }
    }

    public float getSaldo(){
        return conta_saldo;
    }

    public void imprimirExtrato(){
        System.out.println(conta_nome + " possui R$: " + conta_saldo + " em sua conta.");
    }

    public void alterarStatusConta(boolean novoStatus){
        if(conta_ativa && novoStatus) {
            System.out.println("Esta conta já está ativa!");
        }else if(!conta_ativa && !novoStatus){
            System.out.println("Esta conta já está inativa!");
        }else{
            conta_ativa = novoStatus;
            System.out.println("Status da conta " + conta_ID + " alterado para " + (conta_ativa?"Ativa!":"Inativa!"));
        }
    }

    public void imprimirConta(){
        System.out.println("Conta: " + conta_ID +
                "\nProprietário: " + conta_nome +
                "\nSaldo: " + conta_saldo +
                "\nStatus: " + (conta_ativa?"Ativa":"Inativa"));
    }
}
