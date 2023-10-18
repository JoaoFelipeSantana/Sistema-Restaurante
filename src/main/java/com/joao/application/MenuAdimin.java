package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuAdimin {
    ValidacaoEscolhaMenu validate = new ValidacaoEscolhaMenu();
    public void menuProduct() throws IOException {


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

            String option = scanner.next();

            if (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5") && !option.equals("6") &&  !option.equals("7") && !option.equals("0")) {
                System.out.println("\n=================================");
                System.out.println("\u001B[31m          !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
                System.out.println("=================================");
            }

            else {
                validate.validateAdimin(option.strip());
                break;
            }
        }
    }
}
