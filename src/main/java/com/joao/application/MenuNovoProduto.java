package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import java.io.IOException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuNovoProduto {

    public void newProduct() throws IOException {
        FuncoesProdutos fProducts = new FuncoesProdutos();

        String name, description;
        float price;
        int amount;


        //Colhendo os dados do produto
        System.out.println("\n======== REGISTRANDO PRODUTOS ========");

        int flag = 1;
        int flag_error = 1;
        while (flag == 1) {
            Scanner scannerSTR = new Scanner(System.in);
            Scanner scannerNUM = new Scanner(System.in);

            try {
                System.out.print(" - Digite o nome do produto: ");
                name = scannerSTR.nextLine();

                System.out.print(" - Informe a descrição do produto: ");
                description = scannerSTR.nextLine();

                if (!fProducts.validateProduct(name, description)) {
                    System.out.println("\n=====================================");
                    System.out.println("\nNome ou desccrição já existente");
                    System.out.println("Reinicie o programa e tente novamente");
                    System.out.println("=====================================");
                    flag = 2;
                }

                else {
                    System.out.print(" - Quantidade desse produto: ");
                    amount = scannerNUM.nextInt();

                    flag_error = 2;
                    System.out.print(" - Informe o preço do produto: R$");
                    price = scannerNUM.nextFloat();

                    if (fProducts.validateAmount(amount)) {
                        System.out.println("\n=========================================================");
                        System.out.println("Quantidade do produto não pode ser inferior a uma unidade");
                        System.out.println("          Reinicie o programa e tente novamente");
                        System.out.println("=========================================================");
                        flag = 2;
                    }

                    else {
                        fProducts.createProduct(name, description, price, amount);
                        System.out.println("\n========================================");
                        System.out.println("\n\u001B[32m !!! PRODUTO CADASTRADO COM SUCESSO !!! \u001B[m");
                        System.out.println("========================================");
                        flag = 2;
                    }
                }
            }
            catch (InputMismatchException inputMismatchException) {

                if (flag_error == 1) {
                    System.out.println("\n=======================================================");
                    System.out.println("\u001B[31m                     !!! ERRO !!!  \u001B[m");
                    System.out.println("Valor digitado fora dos parâmetros de um número inteiro");
                    System.out.println("           Tente novamente (ex: 1, 2, 3...)");
                    System.out.println("=======================================================\n");
                }
                else {
                    System.out.println("\n====================================================");
                    System.out.println("\u001B[31m                     !!! ERRO !!!  \u001B[m");
                    System.out.println("Valor digitado fora dos parâmetros de um número real");
                    System.out.println("          Tente novamente (ex: 1,2; 7,3...)");
                    System.out.println("====================================================\n");
                }
            }
        }
    }
}
