package com.joao.application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

import java.io.IOException;

public class MenuPedidos {

    public void consultOrders() throws IOException {
        FuncoesPedidos fOrders = new FuncoesPedidos();

        JsonArray orders = fOrders.viewOrders();

        System.out.println("\n========== PEDIDOS ==========");
        for (JsonElement element: orders) {
            if (element.isJsonObject()) {
                JsonObject infoOrders = element.getAsJsonObject();

                int id_table = infoOrders.get("id_mesa").getAsInt();
                String order = infoOrders.get("pedido").getAsString();

                System.out.printf(" - Número da mesa: %d", id_table);
                System.out.printf("\n - Número do(s) pedido: %s", order);
                System.out.println("\n=============================");
            }
        }
    }

}
