package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuIniciar {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuUsuario() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== USUÁRIO =====");
        System.out.println(" [1] Administrador" +
                "\n [2] Cliente" +
                "\n===================");
        System.out.print("Digite a opção que deseja: ");

        String opcao = scanner.next();

        validar.validarUsuario(opcao.strip());
    }
}
