package com.joao.application;

import com.google.gson.JsonElement;
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

        System.out.print("Insira o nome do produto a ser editado: ");
        String name = scanner.nextLine();

        JsonObject produto = fProdutos.consultarProduto(name);

        System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
        System.out.println(" - Nome: " + produto.get("Nome"));
        System.out.println(" - Descrição: " + produto.get("Descrição"));
        System.out.println(" - Preço: " + produto.get("Preço"));
        System.out.println(" - Quantidade: " + produto.get("Quantidade"));
        System.out.println(" - Data de criação: " + produto.get("Data Criação"));
        System.out.println(" - Data de edição: " + produto.get("Data Edição"));
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
            fProdutos.delete(name);
            fProdutos.editarProduto(produto.get("id").getAsInt(), newName, newDescripton, newPrice, newAmount, produto.get("Data Criação").getAsString());
            System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[32m");
        }
        scanner.close();
    }
}
