package com.joao.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

public class MenuEditarPedido {

    public void ediatrPedido() throws IOException {

        FuncoesPedidos fPedidos = new FuncoesPedidos();


        System.out.println("\n===== EDITAR PEDIDO =====");

        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try  {
                System.out.print(" - Informe o número da mesa: ");
                int id_table = scanner.nextInt();
                List<Integer> pratos = new ArrayList<>();

                JsonObject pedido = fPedidos.consultarPedido(id_table);

                if (!pedido.isEmpty()) {

                    System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
                    System.out.println(" - Id: " + pedido.get("id"));
                    System.out.println(" - Número da mesa: " + pedido.get("id_mesa"));
                    System.out.println(" - Pedido: " + pedido.get("pedido"));
                    System.out.println(" - Data de criação: " + pedido.get("dtcreate"));
                    System.out.println(" - Data de edição: " + pedido.get("dtupdate"));
                    System.out.println("===============================");

                    System.out.println("\n===== INFORMAÇÕES ATUALIZADAS =====");
                    System.out.print(" - Digite o número da mesa: ");
                    int newId_table = scanner.nextInt();

                    int opcao = 1;
                    while (opcao == 1) {
                        System.out.print(" - Qual opção do cardápio deseja? ");
                        int order = scanner.nextInt();

                        pratos.add(order);

                        System.out.println("\n-----------------------------");
                        System.out.print("Deseja adicionar outro prato?" +
                                "\n       [1]SIM   [2]NÃO" +
                                "\n-----------------------------\n" +
                                "\nDigite a opção que deseja: ");
                        opcao = scanner.nextInt();
                    }
                    flag = 2;
                    fPedidos.excluirPedido(id_table);

                    fPedidos.editarPedido(pedido.get("id").getAsInt(), newId_table, pratos, pedido.get("dtcreate").getAsString());
                    System.out.println("\n\u001B[32m!!! PEDIDO ATUALIZADO COM SUCESSO !!!\u001B[m");
                }

                else {
                    flag = 2;

                    System.out.println("\n Pedido não encontrado");
                    System.out.println("Reinicie o programa e tente novamente...");
                }

            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println("-------------------------------------------------------");
                System.out.println("\u001B[31m                     !!! ERRO !!!  \u001B[m");
                System.out.println("Valor digitado fora dos parâmetros de um número inteiro");
                System.out.println("           Tente novamente (ex: 1, 2, 3...)");
                System.out.println("-------------------------------------------------------\n");
            }
        }
    }
}
