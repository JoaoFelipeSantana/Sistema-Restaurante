package com.joao.application;

import com.joao.domain.FuncoesPedidos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDeletarPedido {

    public void deleteOrder() {
        FuncoesPedidos fOrders = new FuncoesPedidos();

        System.out.println("\n======== EXCLUINDO MESA ========");
        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print(" - Informe o número da mesa: ");
                int id_table = scanner.nextInt();
                flag = 2;

                if (!fOrders.consultOrder(id_table).isEmpty()) {
                    fOrders.deleteOrder(id_table);
                    System.out.println("\n===================================");
                    System.out.println("\n\u001B[32m !!! MESA EXCLUIDO COM SUCESSO !!! \u001B[m");
                    System.out.println("===================================");
                }
                else {
                    System.out.println("\n========================================");
                    System.out.println("            Mesa não encontrado");
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
