package com.joao.infrastructure.daos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PedidoDAO {

    // Adicionando um pedido ao arquivo pedidos.json
    public void creat(JsonArray novoPedido) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\joao\\database\\pedidos.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(novoPedido.toString());
        wr.close();
        writer.close();
    }


    // Lendo o arquivo pedidos.jon
    public JsonArray read() throws IOException {
        String filePath =  "src\\main\\java\\com\\joao\\database\\pedidos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray arrayNovo = new JsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    arrayNovo.add(local);
                }
            }
            return arrayNovo;
        }
    }

    public JsonObject delete(int id_table) {
        String filePath = "src\\main\\java\\com\\joao\\database\\pedidos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray arrayNovo = new JsonArray();
            JsonObject pedidoDelete = new JsonObject();

            for (JsonElement element: array) {
                if (element.isJsonObject()) {
                    JsonObject pedido = element.getAsJsonObject();
                    if (pedido.get("id_mesa").getAsInt() == id_table) {
                        pedidoDelete = pedido;
                    }
                    else {
                        arrayNovo.add(pedido);
                    }
                }
            }
            creat(arrayNovo);
            return pedidoDelete;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject consultarPedido(int id_table) {
        String filePath = "src\\main\\java\\com\\joao\\database\\pedidos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject pedido = element.getAsJsonObject();
                    if (pedido.get("id_mesa").getAsInt() == id_table) {
                        return pedido;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
