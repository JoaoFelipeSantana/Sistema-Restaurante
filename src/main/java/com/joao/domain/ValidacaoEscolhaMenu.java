package com.joao.domain;

import com.joao.application.*;

import java.io.IOException;

public class ValidacaoEscolhaMenu {
    public void validarUsuario(String opcao) throws IOException {

        if (opcao.equals("1")) {
            MenuAdimin adimin = new MenuAdimin();
            adimin.menuProduto();
        }
        else{
            MenuCliente cliente = new MenuCliente();
            cliente.menuPedido();
        }
    }

    public void validarAdimin(String opcao) throws IOException {

        switch (opcao){
            case "1":
                MenuNovoProduto novoProduto = new MenuNovoProduto();
                novoProduto.infoRegistro();
                break;

            case "2":
                MenuEditarProduto atualizarProduto = new MenuEditarProduto();
                atualizarProduto.editarProduto();
                break;

            case "3":
                MenuConsultarProdutoTudo consultarTudo = new MenuConsultarProdutoTudo();
                consultarTudo.consultarProdutos();
                break;

            case "4":
                MenuDeleteProduto deleteProduto = new MenuDeleteProduto();
                deleteProduto.excluirProduto();
                break;

            case "0":
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
    }

    public void validarCliente(String opcao) throws IOException{

        switch (opcao){
            case "1":
                MenuNovoPedido menuNovoPedido = new MenuNovoPedido();
                menuNovoPedido.novoPedido();
                break;

            case "2":
                MenuEditarPedido menuEditarPedido = new MenuEditarPedido();
                menuEditarPedido.ediatrPedido();
                break;

            case "3":
                MenuDeletarPedido menuDeletarPedido = new MenuDeletarPedido();
                menuDeletarPedido.deletarPedido();
                break;

            case "4":
                MenuPedidos menuPedidos = new MenuPedidos();
                menuPedidos.verPedidos();
                break;

            case "0":
                MenuIniciar voltar = new MenuIniciar();
                voltar.menuUsuario();
                break;
        }
    }
}
