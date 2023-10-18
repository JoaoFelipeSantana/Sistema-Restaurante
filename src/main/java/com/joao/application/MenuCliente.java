package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuCliente {
    ValidacaoEscolhaMenu validate = new ValidacaoEscolhaMenu();
    public void menuOrder() throws IOException {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n========== CLIENTE ==========");
            System.out.println(" [1] Novo pedido" +
                    "\n [2] Ver pedidos" +
                    "\n [0] Voltar ao menu anterior" +
                    "\n=============================");
            System.out.print("Digite a opção que deseja: ");
            String option = scanner.next();

            if (!option.equals("1") && !option.equals("2") && !option.equals("0")) {
                System.out.println("\n=================================");
                System.out.println("\u001B[31m          !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
                System.out.println("=================================");
            }

            else {
                validate.validateClient(option.strip());
                break;
            }
        }
    }
}
