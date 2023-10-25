package com.joao.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.PedidoDAO;
import com.joao.infrastructure.entity.Order;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FuncoesPedidos {

    PedidoDAO pedidoCRUD = new PedidoDAO();

    public void createOrder(int id_table, List<Integer> dishes) throws IOException {
        JsonArray arrayNovo = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtcreate = LocalDateTime.now();

        String dtupdate = null;

        Order order = new Order(arrayNovo.size(), id_table, dishes.toString(), dtf.format(dtcreate), dtupdate);

        pedidoCRUD.create(order ,arrayNovo);

    }

    public JsonArray viewOrders() throws IOException {
        return pedidoCRUD.read();
    }

    public void deleteOrder(int id_table) {
        pedidoCRUD.delete(id_table);
    }

    public JsonObject consultOrder(int id_table) {
        JsonObject order = pedidoCRUD.consultProduct(id_table);
        return order;
    }

    public void editOrder(int id, int id_table, List<Integer> dishes, String dtcreate) throws IOException {
        JsonArray arrayNovo = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtupdate = LocalDateTime.now();

        Order order = new Order(id, id_table, dishes.toString(), dtcreate, dtf.format(dtupdate));

        pedidoCRUD.create(order, arrayNovo);
    }

}
