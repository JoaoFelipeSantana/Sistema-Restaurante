package com.joao.infrastructure.daos;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ProdutoDAO {

    // Criando um novo produto
    public void create(JsonArray newProduct) throws IOException{
        FileWriter writer = new FileWriter("src\\main\\java\\com\\joao\\database\\produtos.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(newProduct.toString());
        wr.close();
        writer.close();

    }

    // Lendo o arquivo produtos.json
    public JsonArray read() throws IOException {
        String filePath = "src\\main\\java\\com\\joao\\database\\produtos.json";
        Path path = Paths.get(filePath);

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

    // Deletando um produto
    public JsonObject delete(int id) {
        String filePath = "src\\main\\java\\com\\joao\\database\\produtos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray arrayNew = new JsonArray();
            JsonObject deleteProduct = new JsonObject();

            for (JsonElement element : array ) {
                if (element.isJsonObject()) {
                    JsonObject product = element.getAsJsonObject();
                    if (!(product.get("id").getAsInt() == id)) {
                        arrayNew.add(product);
                    }
                    else {
                        deleteProduct = product;
                    }
                }
            }
            create(arrayNew);
            return deleteProduct;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject consultProduct(int id) {
        String filePath = "src\\main\\java\\com\\joao\\database\\produtos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonObject empty = new JsonObject();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject product = element.getAsJsonObject();
                    if (product.get("id").getAsInt() == id) {
                        return product;
                    }
                }
            }
            return empty;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
