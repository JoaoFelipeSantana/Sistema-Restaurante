package com.joao.domain;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.ProdutoDAO;
import com.joao.infrastructure.entity.Product;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FuncoesProdutos {

    ProdutoDAO produtoCRUD = new ProdutoDAO();

    // Criando um produto novo
    public void createProduct(String name, String description, float price, int amount) throws IOException {
        JsonArray arrayNew = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtcreate = LocalDateTime.now();

        String dtupdate = null;

        Product product = new Product(arrayNew.size(), name, description, price, amount, dtf.format(dtcreate), dtupdate);

        produtoCRUD.create(product);

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
        JsonArray arrayNovo = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dtupdate = LocalDateTime.now();

        Product editProduct = new Product(id, name, description, price, amount, dtcreate, dtf.format(dtupdate));

        produtoCRUD.create(editProduct);
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
