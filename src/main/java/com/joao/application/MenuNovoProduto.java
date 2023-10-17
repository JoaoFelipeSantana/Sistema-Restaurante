package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import java.io.IOException;

import java.util.Scanner;
public class MenuNovoProduto {

    String name, description;
    float price;
    int amount, flag;


    public void infoRegistro() throws IOException {
        Scanner scannerSTR = new Scanner(System.in);
        Scanner scannerNUM = new Scanner(System.in);

        FuncoesProdutos fProdutos = new FuncoesProdutos();

        //Colhendo os dados do produto
        System.out.println("\n===== REGISTRANDO PRODUTOS =====");

        System.out.print(" - Digite o nome do produto: ");
        name = scannerSTR.nextLine();

        System.out.print(" - Informe a descrição do produto: ");
        description = scannerSTR.nextLine();

        if (!fProdutos.validarProduto(name, description)) {
            System.out.println("\nNome ou desccrição já existente");
            System.out.println("Reinicie o programa e tente novamente");
        }

        else {
            System.out.print(" - Quantidade desse produto: ");
            amount = scannerNUM.nextInt();

            System.out.print(" - Informe o preço do produto: R$");
            price = scannerNUM.nextFloat();

            if (fProdutos.validarAmount(amount)) {
                System.out.println("\nQuantidade do produto não pode ser inferior a uma unidade");
                System.out.println("Reinicie o programa e tente novamente");
            }

            else {
                fProdutos.criarProduto(name, description, price, amount);
                System.out.println("\n\u001B[32m !!! PRODUTO CADASTRADO COM SUCESSO !!! \u001B[m");
            }
        }
    }
}
