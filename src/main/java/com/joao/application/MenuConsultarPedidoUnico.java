package com.joao.application;

import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsultarPedidoUnico {

    public void consultarPedidoUnico() {
        FuncoesPedidos fPedidos = new FuncoesPedidos();

        System.out.println("\n===== CONSULTANDO PEDIDO =====");

        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Digite o número da mesa que deseja consultar: ");
                int id_table = scanner.nextInt();
                flag = 2;

                JsonObject pedido = fPedidos.consultarPedido(id_table);

                if (!pedido.isEmpty()) {
                    System.out.println("\n===== INFOMRAÇÕES DA MESA =====");
                    System.out.println(" - Número da mesa: " + pedido.get("id_mesa"));
                    System.out.println(" - Pedido(s): " + pedido.get("pedido"));
                    System.out.println(" - Última edição: " + pedido.get("dtupdate"));
                    System.out.println("===============================");
                }
                else {
                    System.out.println("\n Mesa não encontrada");
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
