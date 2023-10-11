package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuAdimin {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuProduto() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== ADIMINISTRADOR =====");
        System.out.println(" [1] Registrar novo produto" +
                "\n [2] Editar produto" +
                "\n [3] Ver produtos" +
                "\n [4] Excluir produto" +
                "\n [0] Voltar a o menu anterior" +
                "\n==========================");
        System.out.print("Digite a opção que deseja: ");

        String opcao = scanner.next();
        validar.validarAdimin(opcao.strip());

    }
}
