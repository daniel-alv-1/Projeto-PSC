package com.example.projetopsc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ProjetoPSC?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tenta estabelecer a conexão
            try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
                if (conn != null) {
                    System.out.println("Conexão com o banco estabelecida com sucesso!");
                } else {
                    System.out.println("Falha ao conectar ao banco de dados.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }
}
