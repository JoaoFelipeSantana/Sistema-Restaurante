package com.joao.domain;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.joao.application.MenuNovoProduto;
import com.joao.infrastructure.daos.ProdutoDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
        novoProduto.addProperty("id", (int) arrayNovo.size());
        novoProduto.addProperty("nome", (String) name);
        novoProduto.addProperty("descricao", (String) description);
        novoProduto.addProperty("preco", (float) price);
        novoProduto.addProperty("quantidade", (int) amount);
        novoProduto.addProperty("dtcreate", (String) dtf.format(date));

        arrayNovo.add(novoProduto);

        produtoCRUD.create(arrayNovo);

    }

    // Deletando um produto
    public void delete(int id) {
        produtoCRUD.delete(id);
    }

    public JsonArray todosProdutos() throws IOException {
        return produtoCRUD.read();
    }

    public JsonObject consultarProduto(int id) {
        JsonObject produto = produtoCRUD.consultarProduto(id);
        return produto;
    }

    public void editarProduto (int id, String name, String description, float price, int amount, String dtcreate) throws IOException {
        JsonObject editarProduto = new JsonObject();
        JsonArray arrayNovo = produtoCRUD.read();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();


        editarProduto.addProperty("id", (int) id);
        editarProduto.addProperty("nome", (String) name);
        editarProduto.addProperty("descricao", (String) description);
        editarProduto.addProperty("preco", (float) price);
        editarProduto.addProperty("quantidade", (int) amount);
        editarProduto.addProperty("dtcreate", (String) dtcreate);
        editarProduto.addProperty("dtupdate", (String) dtf.format(date));

        arrayNovo.add(editarProduto);

        produtoCRUD.create(arrayNovo);

    }

    public boolean validarProduto(String name, String description) throws IOException {
        JsonArray dados = produtoCRUD.read();

        for (JsonElement element : dados) {
            JsonObject produto = element.getAsJsonObject();
            if (produto.get("nome").getAsString().equals(name) || produto.get("descricao").getAsString().equals(description)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarAmount(int amount) {
        if (amount <= 0){
            return true;
        }
        return false;
    }
}
