package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuNovoPedido {

    public void newOrder() throws IOException {
        FuncoesPedidos fOrders = new FuncoesPedidos();
        List<Integer> dishes = new ArrayList<>();

        int id_table, optionDishes;


        System.out.println("\n======== REGISTRANDO NOVA MESA ========");

        int flag = 1;
        while (flag == 1) {
            Scanner scannerPedido = new Scanner(System.in);

            try {
                System.out.print(" - Informe o número da sua mesa: ");
                id_table = scannerPedido.nextInt();

                int option = 1;
                while (option == 1) {
                    System.out.print(" - Qual opção do cardápio deseja? ");
                    optionDishes = scannerPedido.nextInt();

                    dishes.add(optionDishes);

                    System.out.println("\n-----------------------------");
                    System.out.print("Deseja adicionar outro prato?" +
                            "\n       [1]SIM   [2]NÃO" +
                            "\n-----------------------------\n" +
                            "\nDigite a opção que deseja: ");
                    option = scannerPedido.nextInt();

                }
                flag = 2;

                fOrders.createOrder(id_table, dishes);
                System.out.println("\n===================================");
                System.out.println("\u001B[32m!!! MESA REGISTRADA COM SUCESSO !!!\u001B[m");
                System.out.println("===================================");

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
