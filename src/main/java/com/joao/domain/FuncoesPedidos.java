package com.joao.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.PedidoDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FuncoesPedidos {

    PedidoDAO pedidoCRUD = new PedidoDAO();

    public void criarPedido(int id_table, int order) throws IOException {
        JsonObject novoPedido = new JsonObject();

        JsonArray pedidoArray = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        novoPedido.addProperty("id_mesa", (int) id_table);
        novoPedido.addProperty("pedido", (int) order);
        novoPedido.addProperty("data criacao", (String) dtf.format(date));

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

    public void editarPedido (int id_table, int order, String dtcreate) throws IOException {
        JsonObject novoPedido = new JsonObject();

        JsonArray pedidoArray = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        novoPedido.addProperty("id_mesa", (int) id_table);
        novoPedido.addProperty("pedido", (int) order);
        novoPedido.addProperty("data criacao", (String) dtcreate);
        novoPedido.addProperty("data edicao", (String) dtf.format(date));

        pedidoArray.add(novoPedido);

        pedidoCRUD.creat(pedidoArray);
    }

}
