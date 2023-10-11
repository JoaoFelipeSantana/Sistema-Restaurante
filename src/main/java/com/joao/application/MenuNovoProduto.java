package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import java.io.IOException;
import java.util.Scanner;
public class MenuNovoProduto {

    String name, description;
    float price;
    int amount;

    Scanner scanner = new Scanner(System.in);
    FuncoesProdutos fProdutos = new FuncoesProdutos();

    public void infoRegistro() throws IOException {
        //Colhendo os dados do produto
        System.out.println("\n===== REGISTRANDO PRODUTOS =====");

        System.out.print(" - Digite o nome do produto: ");
        name = scanner.nextLine();

        System.out.print(" - Informe a descrição do produto: ");
        description = scanner.nextLine();

        System.out.print(" - Informe o preço do produto: R$");
        price = scanner.nextFloat();

        System.out.print(" - Quantidade desse produto: ");
        amount = scanner.nextInt();

        fProdutos.criarProduto(name, description, price, amount);

        System.out.println("\n\u001B[32m !!! PRODUTO CADASTRADO COM SUCESSO !!! \u001B[m");

    }


}
