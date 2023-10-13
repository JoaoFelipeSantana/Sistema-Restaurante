package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuNovoPedido {

    int id_table, order;

    Scanner scannerPedido = new Scanner(System.in);
    FuncoesPedidos fPedidos = new FuncoesPedidos();


    public void novoPedido() throws IOException {

        List<Integer> pratos = new ArrayList<>();

        System.out.println("\n===== FAÇA SEU NOVO PEDIDO =====");
        System.out.print(" - Informe o número da sua mesa: ");
        id_table = scannerPedido.nextInt();

        int opcao = 1;
        while (opcao == 1) {
            System.out.print(" - Qual opção do cardápio deseja? ");
            order = scannerPedido.nextInt();

            pratos.add(order);

            System.out.print("\nDeseja adicionar outro prato?" +
                    "\n       [1]SIM   [2]NÃO" +
                    "\nDigite a opção que deseja: ");
            opcao = scannerPedido.nextInt();
        }

        fPedidos.criarPedido(id_table, pratos);

        System.out.println("\n\u001B[32m!!! PEDIDO REALIZADO COM SUCESSO !!!\u001B[m");

    }
}
