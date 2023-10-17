package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;
import java.util.Scanner;

public class MenuCliente {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuPedido() throws IOException {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n===== CLIENTE =====");
            System.out.println(" [1] Novo pedido" +
                    "\n [2] Ver pedidos" +
                    "\n [0] Voltar ao menu anterior" +
                    "\n===================");
            System.out.print("Digite a opção que deseja: ");
            String opcao = scanner.next();

            if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("0")) {
                System.out.println("\n\u001B[31m   !!! ERRO !!!   \u001B[m");
                System.out.println("Digite novamente uma opção válida");
            }

            else {
                validar.validarCliente(opcao.strip());
                break;
            }
        }
    }
}
