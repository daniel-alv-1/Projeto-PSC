package com.example.projetopsc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telefoneField;

    @FXML
    private void handleCadastrarUsuario(ActionEvent event) {
        String usuario = usuarioField.getText().trim();
        String senha = senhaField.getText().trim();
        String email = emailField.getText().trim();
        String telefone = telefoneField.getText().trim();


        if (usuario.isEmpty() || senha.isEmpty()) {
            System.out.println("Usuário e senha são obrigatórios!");
            return;
        }


        try (Connection conn = Conexao.obterConexao()) {
            String sql = "INSERT INTO classes (usuario, senha, email, telefone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setString(3, email);


            stmt.setString(4, telefone);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário cadastrado com sucesso!");
                limparCampos();
            } else {
                System.out.println("Erro ao cadastrar usuário.");
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão ou comando SQL:");
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        usuarioField.clear();
        senhaField.clear();
        emailField.clear();
        telefoneField.clear();
    }
}
