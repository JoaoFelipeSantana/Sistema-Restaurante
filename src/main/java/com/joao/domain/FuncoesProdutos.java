package com.joao.domain;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joao.infrastructure.daos.ProdutoDAO;

import java.io.IOException;

public class FuncoesProdutos {

    ProdutoDAO produtoCRUD = new ProdutoDAO();

    // Criando um produto novo
    public void criarProduto(String name, String description, float price, int amount) throws IOException {

        // Criando um novo objeto para o produto novo
        JsonObject novoProduto = new JsonObject();

        JsonArray arrayNovo = produtoCRUD.read();

        // Adicionando informações
        novoProduto.addProperty("Nome", (String) name);
        novoProduto.addProperty("Descrição", (String) description);
        novoProduto.addProperty("Preço", (float) price);
        novoProduto.addProperty("Quantidade", (int) amount);

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
}
