package com.joao.application;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

public class MenuEditarPedido {

    public void ediatrPedido() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FuncoesPedidos fPedidos = new FuncoesPedidos();


        System.out.println("\n===== EDITAR PEDIDO =====");

        System.out.print(" - Informe o número da mesa: ");
        int id_table = scanner.nextInt();

        JsonObject pedido = fPedidos.consultarPedido(id_table);

        System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
        System.out.println(" - Número da mesa: " + pedido.get("id_mesa"));
        System.out.println(" - Pedido: " + pedido.get("Pedido"));
        System.out.println("===============================");

        fPedidos.excluirPedido(id_table);

        System.out.println("\n===== INFORMAÇÕES ATUALIZADAS =====");
        System.out.print(" - Digite o número da mesa: ");
        id_table = scanner.nextInt();

        System.out.print(" - Digite seu pedido: ");
        int order = scanner.nextInt();

        fPedidos.criarPedido(id_table, order);

        System.out.println("\n\u001B[32m!!! PEDIDO ATUALIZADO COM SUCESSO !!!\u001B[m");

    }
}
