package com.joao.infrastructure.entity;

public class Order {
    // == ATRIBUTOS ==
    private int id;
    private int id_table;
    private String listProducts;
    private String dtupdate;
    private String dtcreat;

    // Contrutor para setar os valores da entidade
    public Order(int id, int id_table, String listProducts, String dtupdate, String dtcreat) {
        this.id = id;
        this.id_table = id_table;
        this.listProducts = listProducts;
        this.dtupdate = dtupdate;
        this.dtcreat = dtcreat;
    }
}
