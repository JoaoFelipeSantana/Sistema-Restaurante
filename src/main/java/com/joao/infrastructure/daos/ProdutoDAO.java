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
    public void create(JsonArray listaProdutos) throws IOException{
        FileWriter writer = new FileWriter("src\\main\\java\\com\\joao\\database\\produtos.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(listaProdutos.toString());
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
            JsonArray novoArray = new JsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    novoArray.add(local);
                }
            }
            return novoArray;
        }
    }

    // Deletando um produto
    public JsonObject delete(String name) {
        String filePath = "src\\main\\java\\com\\joao\\database\\produtos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();
            JsonArray novoArray = new JsonArray();
            JsonObject deleteProduto = new JsonObject();

            for (JsonElement element : array ) {
                if (element.isJsonObject()) {
                    JsonObject produto = element.getAsJsonObject();
                    if (!produto.get("Nome").getAsString().equals(name)) {
                        novoArray.add(produto);
                    }
                    else {
                        deleteProduto = produto;
                    }
                }
            }
            create(novoArray);
            return deleteProduto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject consultarProduto(String name) {
        String filePath = "src\\main\\java\\com\\joao\\database\\produtos.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement four = parser.parse(reader);
            JsonArray array = four.getAsJsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject produto = element.getAsJsonObject();
                    if (produto.get("Nome").getAsString().equals(name)) {
                        return produto;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
