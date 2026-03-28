package dao;

import factory.ConnectionFactory;
import modelo.Ponto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PontoDAO {

    public List<Ponto> buscarPontos(int idUsuario) {
        List<Ponto> lista = new ArrayList<>();
        String sql = "SELECT * FROM ponto WHERE id_usuario = ?";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {
            pstm.setInt(1, idUsuario);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ponto p = new Ponto();
                p.setNome(rs.getString("nome"));
                p.setMunicipio(rs.getString("municipio"));
                p.setEixoX(rs.getDouble("eixoX"));
                p.setEixoY(rs.getDouble("eixoY"));
                p.setId_usuario(rs.getInt("id_usuario"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void salvarPontos(Ponto ponto) {
        String sql = "INSERT INTO ponto (nome, municipio, eixoX, eixoY, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {
            pstm.setString(1, ponto.getNome());
            pstm.setString(2, ponto.getMunicipio());
            pstm.setDouble(3, ponto.getEixoX());
            pstm.setDouble(4, ponto.getEixoY());
            pstm.setInt(5, ponto.getId_usuario());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}