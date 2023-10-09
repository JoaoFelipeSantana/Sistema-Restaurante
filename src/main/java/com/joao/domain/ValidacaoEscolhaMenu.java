package com.joao.domain;

import com.joao.application.*;

import java.io.IOException;
import java.util.Scanner;

public class ValidacaoEscolhaMenu {
    public void validarUsuario() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 2) {
            System.out.println("\n!!! ERRO !!!");
            System.out.print("Digite novamente uma opção válida: ");
            opcao = scanner.nextInt();
        }

        if (opcao == 1) {
            MenuAdimin adimin = new MenuAdimin();
            adimin.menuProduto();
        }
        else{
            MenuCliente cliente = new MenuCliente();
            cliente.menuPedido();
        }
    }

    public void validarAdimin() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
            System.out.println("\n!!! ERRO !!!");
            System.out.print("Digite novamente uma opção válida: ");
            opcao = scanner.nextInt();
        }

        switch (opcao){
            case 1:
                MenuNovoProduto novoProduto = new MenuNovoProduto();
                novoProduto.infoRegistro();
                break;

            case 2:

                break;

            case 3:
                MenuConsultarProdutoTudo consultarTudo = new MenuConsultarProdutoTudo();
                consultarTudo.consultarProdutos();
                break;

            case 4:
                MenuDeleteProduto deleteProduto = new MenuDeleteProduto();
                deleteProduto.escluirProduto();
                break;

            case 0:
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
    }

    public void validarCliente() throws IOException{
        Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 0) {
            System.out.println("\n!!! ERRO !!!");
            System.out.print("Digite novamente uma opção válida: ");
            opcao = scanner.nextInt();
        }

        switch (opcao){
            case 1:

                break;

            case 2:
                break;

            case 3:
                break;

            case 4:

                break;

            case 0:
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
    }
}
