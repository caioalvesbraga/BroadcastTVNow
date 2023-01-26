package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControleCanal;
import dao.ExceptionDAO;
import model.Canal;

public class TelaConsultaCanal implements ActionListener{
	private JFrame consultaFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel buscaLabel = new JLabel("Digite o Canal :");
	private JTextField buscaTextField = new JTextField();
	private JButton buscaButton = new JButton("Buscar");
	private JTable canaisTable;
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
		
		buscaButton.addActionListener(this);
		
		//Table
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Emissora");
		tableModel.addColumn("Número");
		tableModel.addColumn("Tipo");
		canaisTable = new JTable(tableModel);
		canaisTable.setFont(padraoFonte);
		canaisTable.setBackground(new Color(220, 220, 220));
		
		//Painel
		tabelaPanel.add(new JScrollPane(canaisTable));
		tabelaPanel.setBounds(100, 100, 600, 350);
		tabelaPanel.setBackground(Color.black);
		tabelaPanel.setFont(padraoFonte);
		
		
		consultaPanel.add(buscaLabel);
		consultaPanel.add(buscaTextField);
		consultaPanel.add(buscaButton);
		consultaPanel.add(tabelaPanel);
		consultaPanel.setBounds(30, 100, 890, 480);
		consultaPanel.setBackground(new Color(150, 150, 150));
		consultaFrame.add(consultaPanel);
		consultaPanel.setVisible(true);
		consultaFrame.add(tituloLabel);
		consultaFrame.setVisible(true);
		
	}
	
	public void consultaCanal(java.awt.event.ActionEvent evt) {
		String nome = buscaTextField.getText();
		DefaultTableModel tableModel = (DefaultTableModel) canaisTable.getModel();
		tableModel.setRowCount(0);
		ControleCanal controleCanal = new ControleCanal();
		
		try {
			ArrayList <Canal> canais = controleCanal.listarCanais(nome);
			canais.forEach((Canal canal) -> {
				tableModel.addRow(new Object [] {canal.getEmissora(),
												 canal.getNumero(),
												 canal.getTipo()});
			});
			canaisTable.setModel(tableModel);
		} catch(ExceptionDAO e) {
			Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, e);
		}
	}
		
	public static void main(String[] args) {
		TelaConsultaCanal tela4 = new TelaConsultaCanal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == buscaButton) {
			consultaCanal(e);
		}
		
	}
}
