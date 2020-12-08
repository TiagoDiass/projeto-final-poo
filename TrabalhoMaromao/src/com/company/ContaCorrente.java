package com.company;

public class ContaCorrente extends Conta{

    private float conta_limite;

    public ContaCorrente(int corrente_ID, String corrente_nome, float corrente_saldo, boolean corrente_ativa, float corrente_limite){
        this.conta_ID = corrente_ID;
        this.conta_nome = corrente_nome;
        this.conta_saldo = corrente_saldo;
        this.conta_ativa = corrente_ativa;
        this.conta_limite = corrente_limite;
        this.conta_tipo = "corrente";
    }

    @Override
    public void sacar(float valor_saque) {
        if(valor_saque <= conta_saldo){
            conta_saldo -= valor_saque;
            System.out.println(conta_nome + " agora possui R$: " + conta_saldo );
        }
        else if(valor_saque <= (conta_saldo + conta_limite)){
            conta_limite -= (valor_saque - conta_saldo);
            conta_saldo = 0;
            System.out.println(conta_nome + " teve seu saldo zerado e agora possui um limite de: R$: " + conta_limite );
        }
        else{
            System.out.println(conta_nome + " não pode sacar esse valor, cheque seu extrato!");
        }
    }

    public void setConta_limite(float conta_limite) {
        this.conta_limite = conta_limite;
        System.out.println(conta_nome + " agora possui um limite de R$: " + conta_limite);
    }

    public void emprestimo(float valor_emprestimo){
        if(valor_emprestimo <= conta_limite){
            conta_saldo += valor_emprestimo;
            conta_limite -= valor_emprestimo;
            System.out.println("Empréstimo realizado com sucesso!\n" +
                    " O saldo atual de " + conta_nome + " é de: R$ " + conta_saldo + " \n" +
                    " E o limite atual é de: R$ " + conta_limite + " !");
        }else{
            System.out.println("Você não pode emprestar esse valor, pois, ele é maior que seu limite!");
        }
    }

    @Override
    public void imprimirConta(){
        System.out.println("Conta: " + conta_ID +
                "\nProprietário: " + conta_nome +
                "\nSaldo: " + conta_saldo +
                "\nLimite: " + conta_limite +
                "\nStatus: " + (conta_ativa?"Ativa":"Inativa"));
    }
}
