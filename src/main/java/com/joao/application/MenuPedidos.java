package com.joao.application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.joao.domain.FuncoesPedidos;

import java.io.IOException;

public class MenuPedidos {

    public void verPedidos() throws IOException {
        FuncoesPedidos fPedidos = new FuncoesPedidos();

        JsonArray pedidos = fPedidos.verPedidos();

        System.out.println("\n========== PEDIDOS ==========");
        for (JsonElement element: pedidos) {
            if (element.isJsonObject()) {
                JsonObject infoComanda = element.getAsJsonObject();

                int id_table = infoComanda.get("id_mesa").getAsInt();
                String order = infoComanda.get("pedido").getAsString();

                System.out.printf(" - Número da mesa: %d", id_table);
                System.out.printf("\n - Número do(s) pedido: %s", order);
                System.out.println("\n=============================");
            }
        }
    }

}
