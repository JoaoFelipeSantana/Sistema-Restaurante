package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDeleteProduto {

    public void excluirProduto() {
        FuncoesProdutos fProdutos = new FuncoesProdutos();

        System.out.println("\n===== EXCLUINDO PRODUTO =====");

        int flag = 1;
        while (flag == 1) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print(" - Digite id do produto: ");
                int id = scanner.nextInt();
                flag = 2;

                fProdutos.delete(id);
                System.out.println("\n\u001B[32m !!! PRODUTO EXCLUIDO COM SUCESSO !!! \u001B[m");
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
