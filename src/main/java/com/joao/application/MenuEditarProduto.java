package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class MenuEditarProduto {


    public void editarProduto() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FuncoesProdutos fProdutos = new FuncoesProdutos();

        System.out.println("\n\n===== EDITAR PRODUTO =====");

        System.out.print("Insira o nome do produto a ser editado: ");
        String name = scanner.nextLine();

        JsonObject produto = fProdutos.consultarProduto(name);

        System.out.println("\n===== INFORMAÇÕES ANTIGAS =====");
        System.out.printf(" - Nome: %s", produto.get("Nome"));
        System.out.printf("\n - Descrição: %s", produto.get("Descrição"));
        System.out.print("\n - Preço: " + produto.get("Preço"));
        System.out.println("\n - Quantidade: " + produto.get("Quantidade"));
        System.out.println("==============================");

        fProdutos.delete(name);

        System.out.println("\n===== INFORMAÇÕES ATUALIZADAS =====");

        System.out.print(" - Nome: ");
        String newName = scanner.nextLine();

        System.out.print(" - Descrição: ");
        String newDescripton = scanner.nextLine();

        System.out.print(" - Preço: ");
        float newPrice = scanner.nextFloat();

        System.out.print(" - Quantidade: ");
        int newAmount = scanner.nextInt();

        fProdutos.criarProduto(newName, newDescripton, newPrice, newAmount);

        System.out.println("\u001B[32m!!! PRODUTO ATUALIZADO COM SUCESSO !!!\u001B[32m");

        scanner.close();
    }


}
