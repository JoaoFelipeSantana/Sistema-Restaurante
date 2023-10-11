package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.util.Scanner;

public class MenuDeletarPedido {

    public void deletarPedido() {
        Scanner scanner = new Scanner(System.in);
        FuncoesPedidos fPedidos = new FuncoesPedidos();

        System.out.println("\n===== EXCLUINDO PEDIDO =====");
        System.out.print(" - Informe o número da mesa: ");
        int id_table = scanner.nextInt();

        fPedidos.excluirPedido(id_table);

    }
}
