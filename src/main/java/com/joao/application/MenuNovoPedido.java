package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.io.IOException;
import java.util.Scanner;

public class MenuNovoPedido {

    int id_table, order;

    Scanner scannerPedido = new Scanner(System.in);
    FuncoesPedidos fPedidos = new FuncoesPedidos();


    public void novoPedido() throws IOException {

        System.out.println("\n===== FAÇA SEU NOVO PEDIDO =====");

        System.out.print(" - Informe o número da sua mesa: ");
        id_table = scannerPedido.nextInt();

        System.out.print(" - Qual opção do cardápio deseja? ");
        order = scannerPedido.nextInt();

        fPedidos.criarPedido(id_table, order);

        System.out.println("\n\u001B[32m!!! PEDIDO REALIZADO COM SUCESSO !!!\u001B[m");

    }
}
