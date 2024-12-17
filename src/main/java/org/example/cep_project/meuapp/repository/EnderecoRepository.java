package org.example.cep_project.meuapp.repository;

import org.example.cep_project.meuapp.model.Endereco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class EnderecoRepository {

        private Connection connect() {
            Connection conn = null;
            try {
                String url = "jdbc:mysql://localhost:3306/enderecos_db";
                String user = "root";  // Substitua pelo seu usuário do MySQL
                String password = "";  // Substitua pela sua senha do MySQL
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }

        public void save(Endereco endereco) {
            String sql = "INSERT INTO enderecos(cep, logradouro, bairro, localidade, uf) VALUES(?, ?, ?, ?, ?)";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, endereco.getCep());
                pstmt.setString(2, endereco.getLogradouro());
                pstmt.setString(3, endereco.getBairro());
                pstmt.setString(4, endereco.getLocalidade());
                pstmt.setString(5, endereco.getUf());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        // Implementar métodos para busca, atualização e remoção (CRUD)
}

