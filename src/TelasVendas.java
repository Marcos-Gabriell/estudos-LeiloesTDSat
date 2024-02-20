/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import javax.swing.*;
import java.util.List;

public class TelaVendas extends JFrame {

    private JList<String> listaProdutos;

    public TelaVendas() {
        super("Tela de Vendas");

        List<ProdutosDTO> produtosVendidos = new ProdutosDAO().listarProdutosVendidos();

        String[] nomesProdutos = new String[produtosVendidos.size()];
        for (int i = 0; i < produtosVendidos.size(); i++) {
            nomesProdutos[i] = produtosVendidos.get(i).getNome();
        }

        listaProdutos = new JList<>(nomesProdutos);
        JScrollPane scrollPane = new JScrollPane(listaProdutos);

        add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaVendas::new);
    }
}
