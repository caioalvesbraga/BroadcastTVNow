package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaPrograma {
	
	private JFrame consultaFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel buscaLabel = new JLabel("Digite o Programa :");
	private JTextField buscaTextField = new JTextField();
	private JButton buscaButton = new JButton("Buscar");
	private JList programasList;
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel consultaPanel = new JPanel(null);
	private JPanel tabelaPanel = new JPanel(new GridLayout());
		
	/**
	 * 
	 */
	public TelaConsultaPrograma() {
			
		//Tela
		consultaFrame.setIconImage(iconeTVGrandeImage.getImage());
		consultaFrame.setTitle("Consulta de Programa");
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
		
		//List
		DefaultListModel<String> programas = new DefaultListModel<String>();
		programas.addElement("Jornal Nacional");
		programas.addElement("Bom dia e cia");
		programasList = new JList(programas);
		programasList.setFont(padraoFonte);
		programasList.setBounds(200, 100, 400, 350);
		programasList.setBackground(new Color(220, 220, 220));
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) programasList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//Painel
		
		consultaPanel.add(buscaLabel);
		consultaPanel.add(buscaTextField);
		consultaPanel.add(buscaButton);
		consultaPanel.add(programasList);
		consultaPanel.setBounds(30, 100, 890, 480);
		consultaPanel.setBackground(new Color(150, 150, 150));
		
		consultaFrame.add(consultaPanel);
		consultaPanel.setVisible(true);
		consultaFrame.add(tituloLabel);
		consultaFrame.setVisible(true);
		
	}
		
	public static void main(String[] args) {
		TelaConsultaPrograma tela5 = new TelaConsultaPrograma();
	}
}
