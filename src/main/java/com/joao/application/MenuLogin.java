package com.joao.application;

import java.io.*;
import java.util.Scanner;

public class MenuLogin {

    public void validarLogin() {
        Scanner scanner = new Scanner(System.in);
        MenuAdimin adimin = new MenuAdimin();
        MenuIniciar iniciar = new MenuIniciar();

        String [] infosLogin = new String[2];

        try {
            String fileADM = "src\\main\\java\\com\\joao\\database\\adm.txt";
            File file = new File(fileADM);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String infos = "";

            int i = 0;
            while ((infos = bufferedReader.readLine()) != null) {
                infosLogin[i] = infos;
                i = i + 1;
            }

            System.out.println("\n========== LOGIN ==========");

            System.out.print(" - Informe o usuário: ");
            String user = scanner.nextLine().strip();

            System.out.print(" - Informe a sennha: ");
            String password = scanner.nextLine().strip();


            if (user.equals(infosLogin[0]) && password.equals(infosLogin[1])) {
                System.out.println("\n========================");
                System.out.println("\u001B[32m!!! ACESSO PERMITIDO !!!\u001B[m");
                System.out.println("========================");
                adimin.menuProduto();
            }
            else {
                System.out.println("\n=====================");
                System.out.println("\u001B[31m!!! ACESSO NEGADO !!!\u001B[m");
                System.out.println("=====================");
                iniciar.menuUsuario();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
