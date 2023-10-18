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

    public void createOrder(int id_table, List<Integer> order) throws IOException {
        JsonObject newOrder = new JsonObject();

        JsonArray orderArray = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        newOrder.addProperty("id", (int) orderArray.size());
        newOrder.addProperty("id_mesa", (int) id_table);
        newOrder.addProperty("pedido", ((List<Integer>) order).toString());
        newOrder.addProperty("dtcreate", (String) dtf.format(date));

        orderArray.add(newOrder);

        pedidoCRUD.creat(orderArray);
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

    public void editOrder(int id, int id_table, List<Integer> order, String dtcreate) throws IOException {
        JsonObject newOrder = new JsonObject();

        JsonArray orderArray = pedidoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        newOrder.addProperty("id", (int) id);
        newOrder.addProperty("id_mesa", (int) id_table);
        newOrder.addProperty("pedido", ((List<Integer>) order).toString());
        newOrder.addProperty("dtcreate", (String) dtcreate);
        newOrder.addProperty("dtupdate", (String) dtf.format(date));

        orderArray.add(newOrder);

        pedidoCRUD.creat(orderArray);
    }

}
