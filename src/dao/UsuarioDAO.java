package dao;

import factory.ConnectionFactory;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario logarUsuario(Usuario usuario) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                return usuario;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
