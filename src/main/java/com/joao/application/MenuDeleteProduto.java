package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import java.util.Scanner;

public class MenuDeleteProduto {

    public void excluirProduto() {
        Scanner scanner = new Scanner(System.in);
        FuncoesProdutos fProdutos = new FuncoesProdutos();

        System.out.println("\n===== EXCLUINDO PRODUTO =====");
        System.out.print(" - Digite o nome do produto: ");

        String name = scanner.nextLine();
        fProdutos.delete(name);

        System.out.println("\n\u001B[32m !!! PRODUTO EXCLUIDO COM SUCESSO !!! \u001B[m");

        scanner.close();
    }
}
