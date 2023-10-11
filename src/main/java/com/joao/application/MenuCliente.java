package com.joao.application;

import com.joao.domain.ValidacaoEscolhaMenu;

import java.io.IOException;

public class MenuCliente {
    ValidacaoEscolhaMenu validar = new ValidacaoEscolhaMenu();
    public void menuPedido() throws IOException {
        System.out.println("\n===== CLIENTE =====");
        System.out.println(" [1] Novo pedido" +
                           "\n [2] Editar pedido" +
                           "\n [3] Deletar pedido" +
                           "\n [4] Ver pedidos" +
                           "\n [0] Voltar ao menu anterior" +
                "\n===================");
        System.out.print("Digite a opção que deseja: ");

        validar.validarCliente();
    }
}
