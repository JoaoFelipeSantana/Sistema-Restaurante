package com.joao.application;

import com.joao.domain.FuncoesProdutos;
import com.joao.domain.ValidacaoEscolhaMenu;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class MenuEditarProduto {


    public void editarProduto() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FuncoesProdutos fProdutos = new FuncoesProdutos();
        ValidacaoEscolhaMenu validacaoEscolhaMenu = new ValidacaoEscolhaMenu();

        System.out.println("\n\n===== EDITAR PRODUTO =====");

        System.out.print("Insira o id do produto a ser editado: ");
        int id = scanner.nextInt();

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
            String newName = scanner.nextLine();

            System.out.print(" - Descrição: ");
            String newDescripton = scanner.nextLine();

            System.out.print(" - Preço: ");
            float newPrice = scanner.nextFloat();

            System.out.print(" - Quantidade: ");
            int newAmount = scanner.nextInt();


            if (!validacaoEscolhaMenu.validarAmount(newAmount)) {
                fProdutos.delete(id);
                fProdutos.editarProduto(produto.get("id").getAsInt(), newName, newDescripton, newPrice, newAmount, produto.get("dtcreate").getAsString());
                System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[32m");
            }
        }

        else {
            System.out.println("\n Produto não encontrado");
            System.out.println("Reinicie o prorgama e tente novamente...");
        }

        scanner.close();
    }
}
