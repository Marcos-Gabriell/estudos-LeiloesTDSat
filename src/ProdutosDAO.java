/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ProdutosDAO {
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    


    public void venderProduto(int idProduto) {
        for (ProdutosDTO produto : listagem) {
            if (produto.getId() == idProduto) {
                produto.setStatus("Vendido");
                System.out.println("Produto vendido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}


