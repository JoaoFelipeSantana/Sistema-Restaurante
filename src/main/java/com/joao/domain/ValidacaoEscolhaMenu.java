package com.joao.domain;

import com.joao.application.*;

import java.io.IOException;

public class ValidacaoEscolhaMenu {
    public void validateUsers(String option) throws IOException {

        if (option.equals("1")) {
            MenuLogin login = new MenuLogin();
            login.validateLogin();
        }
        else{
            MenuCliente client = new MenuCliente();
            client.menuOrder();
        }
    }

    public void validateAdimin(String option) throws IOException {

        switch (option){
            case "1":
                MenuNovoProduto newProduct = new MenuNovoProduto();
                newProduct.newProduct();
                break;

            case "2":
                MenuEditarProduto updateProduct = new MenuEditarProduto();
                updateProduct.editProduct();
                break;

            case "3":
                MenuConsultarProdutoTudo consultAll = new MenuConsultarProdutoTudo();
                consultAll.consultProducts();
                break;

            case "4":
                MenuDeleteProduto deleteProduct = new MenuDeleteProduto();
                deleteProduct.deleteProduct();
                break;

            case "5":
                MenuNovoPedido newOrder = new MenuNovoPedido();
                newOrder.newOrder();
                break;

            case "6":
                MenuDeletarPedido deleteOrder = new MenuDeletarPedido();
                deleteOrder.deleteOrder();
                break;

            case "7":
                MenuPedidos orders = new MenuPedidos();
                orders.consultOrders();
                break;

            case "0":
                MenuIniciar back = new MenuIniciar();
                back.menuUsers();
                break;
        }
    }

    public void validateClient(String option) throws IOException{

        switch (option){

            case "1":
                MenuEditarPedido editOrder = new MenuEditarPedido();
                editOrder.editOrder();
                break;

            case "2":
                MenuConsultarPedidoUnico consultOrder = new MenuConsultarPedidoUnico();
                consultOrder.consultSingleOrder();
                break;

            case "0":
                MenuIniciar back = new MenuIniciar();
                back.menuUsers();
                break;
        }
    }
}
