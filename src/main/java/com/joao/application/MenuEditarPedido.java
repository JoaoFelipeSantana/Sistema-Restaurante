package com.joao.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> pratos = new ArrayList<>();

        JsonObject pedido = fPedidos.consultarPedido(id_table);

        System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
        System.out.println(" - Número da mesa: " + pedido.get("id_mesa"));
        System.out.println(" - Pedido: " + pedido.get("pedido"));
        System.out.println(" - Data de criação: " + pedido.get("data criacao"));
        System.out.println(" - Data de edição: " + pedido.get("data edicao"));
        System.out.println("===============================");

        fPedidos.excluirPedido(id_table);

        System.out.println("\n===== INFORMAÇÕES ATUALIZADAS =====");
        System.out.print(" - Digite o número da mesa: ");
        id_table = scanner.nextInt();

        int opcao = 1;
        while (opcao == 1) {
            System.out.print(" - Qual opção do cardápio deseja? ");
            int order = scanner.nextInt();

            pratos.add(order);

            System.out.print("\nDeseja adicionar outro prato?" +
                    "\n       [1]SIM   [2]NÃO" +
                    "\nDigite a opção que deseja: ");
            opcao = scanner.nextInt();
        }
        fPedidos.editarPedido(id_table, pratos, pedido.get("data criacao").getAsString());

        System.out.println("\n\u001B[32m!!! PEDIDO ATUALIZADO COM SUCESSO !!!\u001B[m");

    }
}
