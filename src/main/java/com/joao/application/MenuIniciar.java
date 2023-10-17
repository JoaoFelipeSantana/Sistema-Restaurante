package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuIniciar {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuUsuario() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        while (true) {
            System.out.println("\n===== USUÁRIO =====");
            System.out.println(" [1] Administrador" +
                    "\n [2] Cliente" +
                    "\n===================");
            System.out.print("Digite a opção que deseja: ");
            opcao = scanner.next();

            if (opcao.equals("1") || opcao.equals("2")) {
                validar.validarUsuario(opcao.strip());
                break;
            }
            else {
                System.out.println("\n\u001B[31m   !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
            }
        }
    }
}
