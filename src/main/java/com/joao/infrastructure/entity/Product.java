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
    public Product(int id, String name, String description, float price, int amount,  String dtcreat, String dtupdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.dtcreate = dtcreat;
        this.dtupdate = dtupdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getDtupdate() {
        return dtupdate;
    }

    public String getDtcreate() {
        return dtcreate;
    }
}
