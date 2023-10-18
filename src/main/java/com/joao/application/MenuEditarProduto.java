package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEditarProduto {


    public void editProduct() throws IOException {
        FuncoesProdutos fProducts = new FuncoesProdutos();

        System.out.println("\n\n============ EDITAR PRODUTO ============");

        int flag = 1;
        int flag_error = 1;

        while (flag == 1) {
            Scanner scannerNUM = new Scanner(System.in);
            Scanner scannerSTR = new Scanner (System.in);

            try {
                System.out.print("Insira o id do produto a ser editado: ");
                int id = scannerNUM.nextInt();

                JsonObject products = fProducts.consultProduct(id);

                if (!products.isEmpty()){
                    System.out.println("\n======== INFORMAÇÕES ANTIGAS ========");
                    System.out.println(" - Nome: " + products.get("nome"));
                    System.out.println(" - Descrição: " + products.get("descricao"));
                    System.out.println(" - Preço: " + products.get("preco"));
                    System.out.println(" - Quantidade: " + products.get("quantidade"));
                    System.out.println(" - Data de criação: " + products.get("dtcreate"));
                    System.out.println(" - Data de edição: " + products.get("dtupdate"));
                    System.out.println("=====================================");


                    System.out.println("\n======== INFORMAÇÕES ATUALIZADAS ========");

                    System.out.print(" - Nome: ");
                    String newName = scannerSTR.nextLine();

                    System.out.print(" - Descrição: ");
                    String newDescription = scannerSTR.nextLine();

                    System.out.print(" - Quantidade: ");
                    int newAmount = scannerNUM.nextInt();

                    flag_error = 2;
                    System.out.print(" - Preço: ");
                    float newPrice = scannerNUM.nextFloat();

                    if (fProducts.validateAmount(newAmount)) {
                        System.out.println("\n=========================================================");
                        System.out.println("Quantidade do produto não pode ser inferior a uma unidade");
                        System.out.println("          Reinicie o programa e tente novamente");
                        System.out.println("=========================================================");
                        flag = 2;
                    }

                    else {

                        if (fProducts.validateUpdate(newName, newDescription, newPrice, newAmount, products)) {
                            System.out.println("\n=================================");
                            System.out.println("\n   Nenhuma informação alterada");
                            System.out.println("\u001B[31m!!! ATUALIZAÇÃO NÃO EFETUADA !!!\u001B[m");
                            System.out.println("=================================");
                            flag = 2;
                        }

                        else {
                            fProducts.editProduct(products.get("id").getAsInt(), newName, newDescription, newPrice, newAmount, products.get("dtcreate").getAsString());

                            System.out.println("\n======================================");
                            System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[m");
                            System.out.println("======================================");
                            flag = 2;
                        }
                    }
                }

                else {
                    flag = 2;
                    fProducts.deleteProduct(id);

                    System.out.println("\n========================================");
                    System.out.println("\n         Produto não encontrado");
                    System.out.println("Reinicie o programa e tente novamente...");
                    System.out.println("========================================");
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
