package com.joao.infrastructure.entity;

public class Product {
    // == ATRIBUTOS DE PRODUTO ==
    private int id;
    private String name;
    private String description;
    private float price;
    private int amount;
    private String dtupdate;
    private String dtcreate;

    // == Contrutor para setar os valores da entidade ==
    private Product(int id, String name, String description, float price, int amount, String dtupdate, String dtcreat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.dtupdate = dtupdate;
    }
}
