package com.joao.infrastructure.daos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.joao.infrastructure.entity.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PedidoDAO {

    // COMUNICAÇÃO COM O JSON ESTABELECIDA PARA TODAS AS FUNÇÕES
    String filePath =  "src\\main\\java\\com\\joao\\database\\pedidos.json";
    Path path = Paths.get(filePath);

    // Adicionando um pedido ao arquivo pedidos.json
    public void create(Order order, JsonArray arrayNovo) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\joao\\database\\pedidos.json");
        BufferedWriter wr = new BufferedWriter(writer);

        JsonObject newOrder = new JsonObject();

        newOrder.addProperty("id", (int) order.getId());
        newOrder.addProperty("id_mesa", (int) order.getId_table());
        newOrder.addProperty("pedido", (String) order.getListProducts());
        newOrder.addProperty("dtcreate", (String) order.getDtcreat());
        newOrder.addProperty("dtupdate", (String) order.getDtupdate());

        arrayNovo.add(newOrder);

        wr.write(arrayNovo.toString());
        wr.close();
        writer.close();
    }

    public void createDelete(JsonArray arrayNew) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\joao\\database\\pedidos.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(arrayNew.toString());
        wr.close();
        writer.close();
    }


    // Lendo o arquivo pedidos.jon
    public JsonArray read() throws IOException {

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray arrayNew = new JsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    arrayNew.add(local);
                }
            }
            return arrayNew;
        }
    }

    public JsonObject delete(int id_table) {

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray arrayNew = new JsonArray();
            JsonObject orderDelete = new JsonObject();

            for (JsonElement element: array) {
                if (element.isJsonObject()) {
                    JsonObject order = element.getAsJsonObject();
                    if (order.get("id_mesa").getAsInt() == id_table) {
                        orderDelete = order;
                    }
                    else {
                        arrayNew.add(order);
                    }
                }
            }
            createDelete(arrayNew);
            return orderDelete;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject consultProduct(int id_table) {

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonObject empty = new JsonObject();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject order = element.getAsJsonObject();
                    if (order.get("id_mesa").getAsInt() == id_table) {
                        return order;
                    }
                }
            }
            return empty;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
