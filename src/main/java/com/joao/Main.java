package com.joao;

import com.joao.application.MenuIniciar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuIniciar menu = new MenuIniciar();

        menu.menuUsers();
    }
}
