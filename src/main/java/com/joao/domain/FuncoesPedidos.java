package com.joao.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.PedidoDAO;

import java.io.IOException;

public class FuncoesPedidos {

    PedidoDAO pedidoCRUD = new PedidoDAO();

    public void criarPedido(int id_table, int order) throws IOException {
        JsonObject novoPedido = new JsonObject();

        JsonArray pedidoArray = pedidoCRUD.read();

        novoPedido.addProperty("id_mesa", (int) id_table);
        novoPedido.addProperty("Pedido", (int) order);

        pedidoArray.add(novoPedido);

        pedidoCRUD.creat(pedidoArray);
    }

    public JsonArray verPedidos() throws IOException {
        return pedidoCRUD.read();
    }

    public void excluirPedido(int id_table) {
        pedidoCRUD.delete(id_table);
    }

    public JsonObject consultarPedido(int id_table) {
        JsonObject pedido = pedidoCRUD.consultarPedido(id_table);
        return pedido;
    }

}
