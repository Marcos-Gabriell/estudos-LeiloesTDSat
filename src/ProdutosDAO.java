/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    

    public List<ProdutosDTO> listarProdutosVendidos() {
        List<ProdutosDTO> produtosVendidos = new ArrayList<>();
        conn = null;
        prep = null;
        resultset = null;

        try {

            String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
            prep = conn.prepareStatement(sql);

            // Execute a consulta
            resultset = prep.executeQuery();

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nome = resultset.getString("nome");
                double preco = resultset.getDouble("preco");
                String status = resultset.getString("status");

                ProdutosDTO produto = new ProdutosDTO(id, nome, preco, status);
                produtosVendidos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (prep != null) {
                try {
                    prep.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return produtosVendidos;
    }
}
