package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Main {
    static ArrayList<ContaPoupanca> contasPoupanca = new ArrayList();
    static ArrayList<ContaCorrente> contasCorrente = new ArrayList();

    public static void main(String[] args) {


        /*ContaPoupanca contapoupanca = new ContaPoupanca(1, "Wellington", 500, true);
        contapoupanca.imprimirConta();

        System.out.println("\n \n");

        ContaCorrente contacorre = new ContaCorrente(1, "Wellington", 500, true, 600);
        contacorre.imprimirConta();*/


        menu();
    }
    public static void menu(){
            System.out.println("MENU");
            System.out.println("1) Adicionar conta");
            System.out.println("2) Inativar conta");
            System.out.println("3) Reativar conta");
            System.out.println("4) Imprimir extrato");
            System.out.println("5) Imprimir detalhes da conta");
            System.out.println("6) Realizar empréstimo");
            System.out.println("7) Realizar depósito");
            System.out.println("8) Realizar saque");
            System.out.println("9) Alterar limite");

            System.out.println("Escolha uma opção: ");
            Scanner scan = new Scanner(System.in);
            int opcao = scan.nextInt();

            System.out.println(opcao);
        try{

            switch (opcao){
                case 1 :
                    adicionarConta();
                    break;
                case 2 :
                    inativaConta();
                    break;
                case 3 :
                    ativaConta();
                    break;
                case 4 :
                    imprimirExtratoConta();
                    break;
                case 5 :
                    imprimirDetalhesConta();
                    break;
                case 6 :
                    emprestimoConta();
                    break;
                case 7 :
                    depositoConta();
                    break;
                case 8 :
                    saqueConta();
                    break;
                case 9 :
                    alteraLimite();
                    break;
                default:
                    System.out.println("Opção inválida!");

            }

        }catch(IndexOutOfBoundsException erro){
            System.out.println("Não existe conta com este ID ");
        }catch(InputMismatchException erro){
            System.out.println("Digite apenas números");
        }catch (Exception erro){
            System.out.println("Erro inesperado: " + erro);
        }
            menu();
        }


    public static void adicionarConta(){
        Scanner scanConta = new Scanner(System.in);

        switch (perguntarTipoConta()){
            case 1:

                System.out.println("Insira os dados da conta!");

                int idPoupanca = contasPoupanca.size() + 1;

                System.out.println("Nome: ");
                String nomePoupanca = scanConta.next();

                System.out.println("Saldo: ");
                float saldoPoupanca = Float.parseFloat(scanConta.next());

                contasPoupanca.add(new ContaPoupanca(idPoupanca,nomePoupanca,saldoPoupanca,true));

                System.out.println("\nConta id: "+idPoupanca+" adicionada com sucesso!\n");
                break;
            case 2 :
                int idCorrente = contasCorrente.size() + 1;

                System.out.println("Nome: ");
                String nomeCorrente = scanConta.next();

                System.out.println("Saldo: ");
                float saldoCorrente =  Float.parseFloat(scanConta.next());

                System.out.println("Limite: ");
                float limiteCorrente =  Float.parseFloat(scanConta.next());

                contasCorrente.add(new ContaCorrente(idCorrente,nomeCorrente,saldoCorrente,true, limiteCorrente));

                System.out.println("\nConta id: "+idCorrente+" adicionada com sucesso!\n");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void imprimirDetalhesConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).imprimirConta();
        }else if(resposta == 2){
            contasCorrente.get(id - 1).imprimirConta();
        }
    }

    public static void imprimirExtratoConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).imprimirExtrato();
        }else if(resposta == 2){
            contasCorrente.get(id - 1).imprimirExtrato();
        }
    }

    public static void inativaConta() {
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).alterarStatusConta(false);
        }else if(resposta == 2){
            contasCorrente.get(id - 1).alterarStatusConta(false);
        }
    }

    public static void ativaConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).alterarStatusConta(true);
        }else if(resposta == 2){
            contasCorrente.get(id - 1).alterarStatusConta(true);
        }
    }

    public static void emprestimoConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        System.out.println("\nDigite o valor para empréstimo: ");
        Scanner scanConta = new Scanner(System.in);
        float valor = scanConta.nextFloat();

        if(resposta == 2) {
            contasCorrente.get(id-1).emprestimo(valor);
        }else{
            System.out.println("\nSomente contas correntes realizam empréstimos!\n");
        }
    }

    public static int perguntarTipoConta(){
        int opcao = 0;
        do {
            System.out.println("\nQual o tipo de conta?:");
            System.out.println("1)Conta poupança");
            System.out.println("2)Conta corrente");

            System.out.println("\nEscolha uma opção: ");
            Scanner scanConta = new Scanner(System.in);
            opcao = scanConta.nextInt();

            if(opcao != 1 && opcao != 2){
                System.out.println("\nOpção inválida! Digite novamente\n");
            }
        }while(opcao != 1 && opcao != 2);
        return opcao;
    }

    public static int perguntaIdConta(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ID da conta: ");
        int id = scan.nextInt();
        return id;
    }

    public static void depositoConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        System.out.println("\nDigite o valor para depósito: ");
        Scanner scanConta = new Scanner(System.in);
        float valor = scanConta.nextFloat();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).depositar(valor);
        }else if(resposta == 2){
            contasCorrente.get(id - 1).depositar(valor);
        }

    }

    public static void saqueConta(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        System.out.println("\nDigite o valor para saque: ");
        Scanner scanConta = new Scanner(System.in);
        float valor = scanConta.nextFloat();

        if(resposta == 1) {
            contasPoupanca.get(id - 1).sacar(valor);
        }else if(resposta == 2){
            contasCorrente.get(id - 1).sacar(valor);
        }

    }

    public static void alteraLimite(){
        int resposta = perguntarTipoConta();
        int id = perguntaIdConta();

        System.out.println("\nDigite o novo limite: ");
        Scanner scanConta = new Scanner(System.in);
        float valor = scanConta.nextFloat();

        if(resposta == 2) {
            contasCorrente.get(id-1).setConta_limite(valor);
        }else{
            System.out.println("\nSomente contas correntes possuem limite!\n");
        }
    }
}




