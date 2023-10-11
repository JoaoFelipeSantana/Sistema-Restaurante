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
        scanner.close();
    }

    public void validarAdimin() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 0) {
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
                MenuEditarProduto atualizarProduto = new MenuEditarProduto();
                atualizarProduto.editarProduto();
                break;

            case 3:
                MenuConsultarProdutoTudo consultarTudo = new MenuConsultarProdutoTudo();
                consultarTudo.consultarProdutos();
                break;

            case 4:
                MenuDeleteProduto deleteProduto = new MenuDeleteProduto();
                deleteProduto.excluirProduto();
                break;

            case 0:
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
        scanner.close();
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
                MenuNovoPedido menuNovoPedido = new MenuNovoPedido();
                menuNovoPedido.novoPedido();
                break;

            case 2:
                MenuEditarPedido menuEditarPedido = new MenuEditarPedido();
                menuEditarPedido.ediatrPedido();
                break;

            case 3:
                MenuDeletarPedido menuDeletarPedido = new MenuDeletarPedido();
                menuDeletarPedido.deletarPedido();
                break;

            case 4:
                MenuPedidos menuPedidos = new MenuPedidos();
                menuPedidos.verPedidos();
                break;

            case 0:
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
    scanner.close();
    }
}
