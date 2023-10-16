package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class MenuEditarProduto {


    public void editarProduto() throws IOException {
        Scanner scannerNUM = new Scanner(System.in);
        Scanner scannerSTR = new Scanner (System.in);
        FuncoesProdutos fProdutos = new FuncoesProdutos();

        System.out.println("\n\n===== EDITAR PRODUTO =====");

        System.out.print("Insira o id do produto a ser editado: ");
        int id = scannerNUM.nextInt();

        JsonObject produto = fProdutos.consultarProduto(id);

        if (!produto.isEmpty()){
            System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
            System.out.println(" - Nome: " + produto.get("nome"));
            System.out.println(" - Descrição: " + produto.get("descricao"));
            System.out.println(" - Preço: " + produto.get("preco"));
            System.out.println(" - Quantidade: " + produto.get("quantidade"));
            System.out.println(" - Data de criação: " + produto.get("dtcreate"));
            System.out.println(" - Data de edição: " + produto.get("dtupdate"));
            System.out.println("==============================");


            System.out.println("\n===== INFORMAÇÕES ATUALIZADAS =====");

            System.out.print(" - Nome: ");
            String newName = scannerSTR.nextLine();

            System.out.print(" - Descrição: ");
            String newDescription = scannerSTR.nextLine();

            if (!fProdutos.validarProduto(newName, newDescription)) {
                System.out.println("\nNome ou desccrição já existente");
                System.out.println("Reinicie o programa e tente novamente");
            }

            else {
                System.out.print(" - Preço: ");
                float newPrice = scannerNUM.nextFloat();

                System.out.print(" - Quantidade: ");
                int newAmount = scannerNUM.nextInt();


                if (fProdutos.validarAmount(newAmount)) {
                    System.out.println("\nQuantidade do produto não pode ser inferior a uma unidade");
                    System.out.println("Reinicie o programa e tente novamente");
                }

                else {
                    fProdutos.delete(id);
                    fProdutos.editarProduto(produto.get("id").getAsInt(), newName, newDescription, newPrice, newAmount, produto.get("dtcreate").getAsString());
                    System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[32m");
                }

            }

        }

        else {
            System.out.println("\n Produto não encontrado");
            System.out.println("Reinicie o programa e tente novamente...");
        }
    }
}
