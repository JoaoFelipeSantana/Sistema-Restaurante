package com.joao.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

public class MenuEditarPedido {

    public void editOrder() throws IOException {

        FuncoesPedidos fOrders = new FuncoesPedidos();


        System.out.println("\n======== EDITAR PEDIDO ========");

        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try  {
                System.out.print(" - Informe o número da mesa: ");
                int id_table = scanner.nextInt();
                List<Integer> dishes = new ArrayList<>();

                JsonObject order = fOrders.consultOrder(id_table);

                if (!order.isEmpty()) {

                    System.out.println("\n========== INFORMAÇÕES ANTIGAS ==========");
                    System.out.println(" - Id: " + order.get("id"));
                    System.out.println(" - Número da mesa: " + order.get("id_mesa"));
                    System.out.println(" - Pedido: " + order.get("pedido"));
                    System.out.println(" - Data de criação: " + order.get("dtcreate"));
                    System.out.println(" - Data de edição: " + order.get("dtupdate"));
                    System.out.println("=========================================");

                    System.out.println("\n======= INFORMAÇÕES ATUALIZADAS =======");

                    int option = 1;
                    while (option == 1) {
                        System.out.print(" - Qual opção do cardápio deseja? ");
                        int optionDishes = scanner.nextInt();

                        dishes.add(optionDishes);

                        System.out.println("\n-----------------------------");
                        System.out.print("Deseja adicionar outro prato?" +
                                "\n       [1]SIM   [2]NÃO" +
                                "\n-----------------------------\n" +
                                "\nDigite a opção que deseja: ");
                        option = scanner.nextInt();
                    }
                    flag = 2;
                    fOrders.deleteOrder(id_table);
                    fOrders.editOrder(order.get("id").getAsInt(), order.get("id_mesa").getAsInt(), dishes, order.get("dtcreate").getAsString());

                    System.out.println("\n======================================");
                    System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[m");
                    System.out.println("======================================");
                }

                else {
                    flag = 2;
                    System.out.println("\n========================================");
                    System.out.println("          Pedido não encontrado");
                    System.out.println("Reinicie o programa e tente novamente...");
                    System.out.println("========================================");
                }

            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println("\n=======================================================");
                System.out.println("\u001B[31m                     !!! ERRO !!!  \u001B[m");
                System.out.println("Valor digitado fora dos parâmetros de um número inteiro");
                System.out.println("           Tente novamente (ex: 1, 2, 3...)");
                System.out.println("=======================================================\n");
            }
        }
    }
}
