package com.joao.application;

import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsultarPedidoUnico {

    public void consultSingleOrder() {
        FuncoesPedidos fOrders = new FuncoesPedidos();

        System.out.println("\n============== CONSULTANDO PEDIDO ==============");

        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Digite o número da mesa que deseja consultar: ");
                int id_table = scanner.nextInt();
                flag = 2;

                JsonObject order = fOrders.consultOrder(id_table);

                if (!order.isEmpty()) {
                    System.out.println("\n========== INFOMRAÇÕES DA MESA ==========");
                    System.out.println(" - Número da mesa: " + order.get("id_mesa"));
                    System.out.println(" - Pedido(s): " + order.get("pedido"));
                    System.out.println(" - Última edição: " + order.get("dtupdate"));
                    System.out.println("=========================================");
                }
                else {
                    System.out.println("\n==========================================");
                    System.out.println("          Mesa não encontrada");
                    System.out.println(" Reinicie o programa e tente novamente...");
                    System.out.println("==========================================");
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
