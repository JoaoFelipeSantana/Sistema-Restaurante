package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;

public class MenuIniciar {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuUsuario() throws IOException {

        System.out.println("\n===== USUÁRIO =====");
        System.out.println(" [1] Administrador" +
                "\n [2] Cliente" +
                "\n===================");
        System.out.print("Digite a opção que deseja: ");

        validar.validarUsuario();
    }
}
