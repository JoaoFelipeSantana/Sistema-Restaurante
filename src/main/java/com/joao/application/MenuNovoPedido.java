package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuNovoPedido {

    int id_table, order;


    FuncoesPedidos fPedidos = new FuncoesPedidos();


    public void novoPedido() throws IOException {

        List<Integer> pratos = new ArrayList<>();

        System.out.println("\n======== REGISTRANDO NOVA MESA ========");

        int flag = 1;
        while (flag == 1) {
            Scanner scannerPedido = new Scanner(System.in);

            try {
                System.out.print(" - Informe o número da sua mesa: ");
                id_table = scannerPedido.nextInt();

                int opcao = 1;
                while (opcao == 1) {
                    System.out.print(" - Qual opção do cardápio deseja? ");
                    order = scannerPedido.nextInt();

                    pratos.add(order);

                    System.out.println("\n-----------------------------");
                    System.out.print("Deseja adicionar outro prato?" +
                            "\n       [1]SIM   [2]NÃO" +
                            "\n-----------------------------\n" +
                            "\nDigite a opção que deseja: ");
                    opcao = scannerPedido.nextInt();

                }
                flag = 2;

                fPedidos.criarPedido(id_table, pratos);
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
