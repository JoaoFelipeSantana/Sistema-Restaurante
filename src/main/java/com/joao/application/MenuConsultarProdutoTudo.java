package com.joao.application;

import com.joao.domain.FuncoesProdutos;

import com.google.gson.*;

import java.io.IOException;
import java.sql.SQLOutput;

public class MenuConsultarProdutoTudo {

    public void consultarProdutos() throws IOException {

        FuncoesProdutos fProdutos = new FuncoesProdutos();

        JsonArray todosProdutos = fProdutos.todosProdutos();

        System.out.println("\n===== PRODUTOS =====");
        for(JsonElement element : todosProdutos) {
            if (element.isJsonObject()) {
                JsonObject produtos = element.getAsJsonObject();

                String nome = produtos.get("Nome").getAsString();
                String description = produtos.get("Descrição").getAsString();
                float price = produtos.get("Preço").getAsFloat();
                int amount = produtos.get("Quantidade").getAsInt();

                System.out.println(" - Nome: " + nome);
                System.out.println(" - Descrição: " + description);
                System.out.println(" - Preço: " + price);
                System.out.println(" - Quantidade: " + amount);
                System.out.println("\n====================");
            }
        }
    }





}
