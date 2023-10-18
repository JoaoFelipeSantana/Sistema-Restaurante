package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.*;

import java.io.IOException;
import java.sql.SQLOutput;

public class MenuConsultarProdutoTudo {

    public void consultarProdutos() throws IOException {

        FuncoesProdutos fProdutos = new FuncoesProdutos();

        JsonArray todosProdutos = fProdutos.todosProdutos();

        System.out.println("\n=============== PRODUTOS ===============");
        for(JsonElement element : todosProdutos) {
            if (element.isJsonObject()) {
                JsonObject produtos = element.getAsJsonObject();

                int id = produtos.get("id").getAsInt();
                String nome = produtos.get("nome").getAsString();
                String description = produtos.get("descricao").getAsString();
                float price = produtos.get("preco").getAsFloat();
                int amount = produtos.get("quantidade").getAsInt();

                System.out.println(" - Número do produto: " + id);
                System.out.println(" - Nome: " + nome);
                System.out.println(" - Descrição: " + description);
                System.out.println(" - Preço: " + price);
                System.out.println(" - Quantidade: " + amount);
                System.out.println("========================================");
            }
        }
    }





}
