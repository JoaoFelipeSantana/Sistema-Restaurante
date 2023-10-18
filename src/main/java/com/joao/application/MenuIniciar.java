package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuIniciar {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuUsers() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String option;

        while (true) {
            System.out.println("\n=========== USUÁRIO ===========");
            System.out.println(" [1] Administrador" +
                    "\n [2] Cliente" +
                    "\n===============================");
            System.out.print("Digite a opção que deseja: ");
            option = scanner.next();

            if (option.equals("1") || option.equals("2")) {
                validar.validateUsers(option.strip());
                break;
            }
            else {
                System.out.println("\n=================================");
                System.out.println("\u001B[31m          !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
                System.out.println("=================================");
            }
        }
    }
}
