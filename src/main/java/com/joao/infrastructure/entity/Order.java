package com.joao.infrastructure.entity;

public class Order {
    // == ATRIBUTOS ==
    private int id;
    private int id_table;
    private String listProducts;
    private String dtupdate;
    private String dtcreat;

    // Contrutor para setar os valores da entidade
    public Order(int id, int id_table, String listProducts, String dtcreat, String dtupdate) {
        this.id = id;
        this.id_table = id_table;
        this.listProducts = listProducts;
        this.dtupdate = dtupdate;
        this.dtcreat = dtcreat;
    }

    public int getId() {
        return id;
    }

    public int getId_table() {
        return id_table;
    }

    public String getListProducts() {
        return listProducts;
    }

    public String getDtupdate() {
        return dtupdate;
    }

    public String getDtcreat() {
        return dtcreat;
    }
}
