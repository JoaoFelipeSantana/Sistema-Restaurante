package com.joao.domain;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.ProdutoDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FuncoesProdutos {

    ProdutoDAO produtoCRUD = new ProdutoDAO();

    // Criando um produto novo
    public void createProduct(String name, String description, float price, int amount) throws IOException {
        // Criando um novo objeto para o produto novo
        JsonObject newProduct = new JsonObject();
        JsonArray arrayNew = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        // Adicionando informações
        newProduct.addProperty("id", (int) arrayNew.size());
        newProduct.addProperty("nome", (String) name);
        newProduct.addProperty("descricao", (String) description);
        newProduct.addProperty("preco", (float) price);
        newProduct.addProperty("quantidade", (int) amount);
        newProduct.addProperty("dtcreate", (String) dtf.format(date));

        arrayNew.add(newProduct);

        produtoCRUD.create(arrayNew);

    }

    // Deletando um produto
    public void deleteProduct(int id) {
        produtoCRUD.delete(id);
    }

    public JsonArray allProducts() throws IOException {
        return produtoCRUD.read();
    }

    public JsonObject consultProduct(int id) {
        JsonObject product = produtoCRUD.consultProduct(id);
        return product;
    }

    public void editProduct(int id, String name, String description, float price, int amount, String dtcreate) throws IOException {
        JsonObject editProduct = new JsonObject();
        JsonArray arrayNovo = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();


        editProduct.addProperty("id", (int) id);
        editProduct.addProperty("nome", (String) name);
        editProduct.addProperty("descricao", (String) description);
        editProduct.addProperty("preco", (float) price);
        editProduct.addProperty("quantidade", (int) amount);
        editProduct.addProperty("dtcreate", (String) dtcreate);
        editProduct.addProperty("dtupdate", (String) dtf.format(date));

        arrayNovo.add(editProduct);

        produtoCRUD.create(arrayNovo);

    }

    public boolean validateProduct(String name, String description) throws IOException {
        JsonArray date = produtoCRUD.read();

        for (JsonElement element : date) {
            JsonObject product = element.getAsJsonObject();
            if (product.get("nome").getAsString().equals(name) || product.get("descricao").getAsString().equals(description)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateAmount(int amount) {
        if (amount <= 0){
            return true;
        }
        return false;
    }

    public boolean validateUpdate(String newName, String newDescription, Float newPrice, int newAmount, JsonObject produto) {
        if (produto.get("nome").getAsString().equals(newName) &&
                produto.get("descricao").getAsString().equals(newDescription) &&
                produto.get("preco").getAsFloat() == newPrice &&
                produto.get("quantidade").getAsInt() == newAmount) {
            return true;
        }
    return false;
    }
}
