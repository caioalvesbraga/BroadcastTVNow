package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaCanal {
	private JFrame consultaFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel buscaLabel = new JLabel("Digite o Canal :");
	private JTextField buscaTextField = new JTextField();
	private JButton buscaButton = new JButton("Buscar");
	private JTable consultaTable;
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel consultaPanel = new JPanel(null);
	private JPanel tabelaPanel = new JPanel(new GridLayout());
		
	
	public TelaConsultaCanal() {
			
		//Tela
		consultaFrame.setIconImage(iconeTVGrandeImage.getImage());
		consultaFrame.setTitle("Consulta de Canais");
		consultaFrame.setBounds(320, 120, 960, 640);
		consultaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		consultaFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		
		//Label
		tituloLabel = new JLabel("Consulta de Canal", iconeTVMedioImage, JLabel.CENTER);
		tituloLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
		tituloLabel.setForeground(Color.WHITE);
		tituloLabel.setVerticalAlignment(SwingConstants.TOP);
		
		buscaLabel.setFont(padraoFonte);
		Dimension buscaSize = buscaLabel.getPreferredSize();
		buscaLabel.setBounds(60, 40, buscaSize.width, buscaSize.height);
		
		//TextField
		buscaTextField.setBounds(200, 40, 400, 30);
		buscaTextField.setFont(padraoFonte);
		
		//Button
		buscaButton.setBounds(630, 40, 100, 32);
		buscaButton.setFont(padraoFonte);
		
		//Table
		String[] colunas = {"Gênero","Nome","Número"};
		String [][] dados = {{"Variedas", "Rede Globo", "10"}};
		consultaTable = new JTable(dados, colunas);
		consultaTable.setFont(padraoFonte);
		consultaTable.getTableHeader().setFont(padraoFonte);
		consultaTable.setRowHeight(30);
		JScrollPane scroll = new JScrollPane(consultaTable);
		
		
		
		//Painel
		tabelaPanel.setBounds(80, 100, 650, 350);
		tabelaPanel.add(scroll);
		
		consultaPanel.add(tabelaPanel);
		consultaPanel.add(buscaLabel);
		consultaPanel.add(buscaTextField);
		consultaPanel.add(buscaButton);
		consultaPanel.setBounds(30, 100, 890, 480);
		consultaPanel.setBackground(new Color(150, 150, 150));
		
		consultaFrame.add(consultaPanel);
		consultaPanel.setVisible(true);
		consultaFrame.add(tituloLabel);
		consultaFrame.setVisible(true);
		
	}
		
	public static void main(String[] args) {
		TelaConsultaCanal tela4 = new TelaConsultaCanal();
	}
}
