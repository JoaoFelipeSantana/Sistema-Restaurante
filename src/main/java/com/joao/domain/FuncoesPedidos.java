package com.joao.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.PedidoDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FuncoesPedidos {

    PedidoDAO pedidoCRUD = new PedidoDAO();

    public void createOrder(int id_table, List<Integer> dishes) throws IOException {
        JsonArray order = pedidoCRUD.read();

        JsonObject newOrder =  new JsonObject();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtcreate = LocalDateTime.now();

        newOrder.addProperty("id", (int) order.size());
        newOrder.addProperty("id_mesa", (int) id_table);
        newOrder.addProperty("pedido", (String) dishes.toString());
        newOrder.addProperty("dtcreate", (String) dtf.format(dtcreate));

        order.add(newOrder);

        pedidoCRUD.create(order);

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
        JsonArray order = pedidoCRUD.read();

        JsonObject newOrder =  new JsonObject();
        JsonArray array = new JsonArray();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtupdate = LocalDateTime.now();

        newOrder.addProperty("id", (int) order.size());
        newOrder.addProperty("id_mesa", (int) id_table);
        newOrder.addProperty("pedido", (String) dishes.toString());
        newOrder.addProperty("dtcreate", (String) dtcreate);
        newOrder.addProperty("dtupdate", (String) dtf.format(dtupdate));

        array.add(newOrder);

        pedidoCRUD.create(array);
    }

}
