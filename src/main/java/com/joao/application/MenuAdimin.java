package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuAdimin {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuProduto() throws IOException {


        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n======== ADIMINISTRADOR ========");
            System.out.println(" [1] Registrar novo produto" +
                    "\n [2] Editar produto" +
                    "\n [3] Ver produtos" +
                    "\n [4] Excluir produto" +
                    "\n [5] Registrar nova mesa" +
                    "\n [6] Excluir mesa" +
                    "\n [7] Lista de pedidos" +
                    "\n [0] Voltar a o menu anterior" +
                    "\n================================");
            System.out.print("Digite a opção que deseja: ");

            String opcao = scanner.next();

            if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") &&  !opcao.equals("7") && !opcao.equals("0")) {
                System.out.println("\n=================================");
                System.out.println("\u001B[31m          !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
                System.out.println("=================================");
            }

            else {
                validar.validarAdimin(opcao.strip());
                break;
            }
        }
    }
}
