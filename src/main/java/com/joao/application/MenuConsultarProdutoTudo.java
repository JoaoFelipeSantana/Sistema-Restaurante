package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.*;

import java.io.IOException;

public class MenuConsultarProdutoTudo {

    public void consultProducts() throws IOException {

        FuncoesProdutos fProducts = new FuncoesProdutos();

        JsonArray allProducts = fProducts.allProducts();

        System.out.println("\n=============== PRODUTOS ===============");
        for(JsonElement element : allProducts) {
            if (element.isJsonObject()) {
                JsonObject produtos = element.getAsJsonObject();

                int id = produtos.get("id").getAsInt();
                String name = produtos.get("nome").getAsString();
                String description = produtos.get("descricao").getAsString();
                float price = produtos.get("preco").getAsFloat();
                int amount = produtos.get("quantidade").getAsInt();

                System.out.println(" - Número do produto: " + id);
                System.out.println(" - Nome: " + name);
                System.out.println(" - Descrição: " + description);
                System.out.println(" - Preço: " + price);
                System.out.println(" - Quantidade: " + amount);
                System.out.println("========================================");
            }
        }
    }





}
