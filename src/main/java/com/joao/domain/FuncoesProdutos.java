package com.joao.domain;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.ProdutoDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FuncoesProdutos {

    ProdutoDAO produtoCRUD = new ProdutoDAO();

    // Criando um produto novo
    public void criarProduto(String name, String description, float price, int amount) throws IOException {
        // Criando um novo objeto para o produto novo
        JsonObject novoProduto = new JsonObject();
        JsonArray arrayNovo = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        // Adicionando informações
        novoProduto.addProperty("Nome", (String) name);
        novoProduto.addProperty("Descrição", (String) description);
        novoProduto.addProperty("Preço", (float) price);
        novoProduto.addProperty("Quantidade", (int) amount);
        novoProduto.addProperty("Data Criação", (String) dtf.format(date));

        arrayNovo.add(novoProduto);

        produtoCRUD.create(arrayNovo);

    }

    // Deletando um produto
    public void delete(String name) {
        produtoCRUD.delete(name);
    }

    public JsonArray todosProdutos() throws IOException {
        return produtoCRUD.read();
    }

    public JsonObject consultarProduto(String name) {
        JsonObject produto = produtoCRUD.consultarProduto(name);
        return produto;
    }

    public void editarProduto (String name, String description, float price, int amount, String dtcreate) throws IOException {
        JsonObject editarProduto = new JsonObject();
        JsonArray arrayNovo = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        editarProduto.addProperty("Nome", (String) name);
        editarProduto.addProperty("Descrição", (String) description);
        editarProduto.addProperty("Preço", (float) price);
        editarProduto.addProperty("Quantidade", (int) amount);
        editarProduto.addProperty("Data Criação", (String) dtcreate);
        editarProduto.addProperty("Data Edição", (String) dtf.format(date));

        arrayNovo.add(editarProduto);

        produtoCRUD.create(arrayNovo);

    }
}
