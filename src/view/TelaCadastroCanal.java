package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class TelaCadastroCanal {
	private JFrame cadastroFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel nomeLabel = new JLabel("Nome");
	private JLabel numeroLabel = new JLabel("Número");
	private JLabel generoLabel = new JLabel("Gênero");
	private JTextField nomeTextField = new JTextField();
	private JTextField numeroTextField = new JTextField();
	private JComboBox generoComboBox;
	private JButton cancelaButton = new JButton("Cancelar");
	private JButton consultaButton = new JButton("Consultar");
	private JButton limpaButton = new JButton("Limpar");
	private JButton salvaButton = new JButton("Salvar");
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private Font buttonFont = new Font("Bodoni MT Condensed", Font.BOLD, 26);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel cadastroPanel = new JPanel(null);
	
	public TelaCadastroCanal() {
		
		//Tela
		cadastroFrame.setIconImage(iconeTVGrandeImage.getImage());
		cadastroFrame.setTitle("Cadastro de Canais");
		cadastroFrame.setBounds(320, 120, 960, 640);
		cadastroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastroFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		
		//Label
		tituloLabel = new JLabel("Cadastro de Canal", iconeTVMedioImage, JLabel.CENTER);
		tituloLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
		tituloLabel.setForeground(Color.WHITE);
		tituloLabel.setVerticalAlignment(SwingConstants.TOP);
		
		nomeLabel.setFont(padraoFonte);
		Dimension nomeSize = nomeLabel.getPreferredSize();
		nomeLabel.setBounds(80, 80, nomeSize.width, nomeSize.height);
		
		numeroLabel.setFont(padraoFonte);
		Dimension numeroSize = numeroLabel.getPreferredSize();
		numeroLabel.setBounds(80, 150, numeroSize.width, numeroSize.height);
		
		generoLabel.setFont(padraoFonte);
		Dimension generoSize = generoLabel.getPreferredSize();
		generoLabel.setBounds(80, 220, generoSize.width, generoSize.height);
		
		//Text Field
		nomeTextField.setBounds(150, 80, 300, 30);
		nomeTextField.setFont(padraoFonte);
	
		numeroTextField.setBounds(150, 150, 40, 30);
		numeroTextField.setFont(padraoFonte);
		
		//ComboBox
		String [] generos = {"Cinematográfico", "Esportivo", "Jornalístico", "Musical", 
				"Religioso", "Variedades"};
		generoComboBox = new JComboBox(generos);
		generoComboBox.setBounds(150, 220, 150, 30);
		generoComboBox.setFont(padraoFonte);
		
		//Buttons
		
		salvaButton.setBounds(60, 300, 100, 30);
		salvaButton.setFont(buttonFont);
		salvaButton.setBackground(new Color(60,179,113));
		
		limpaButton.setBounds(200, 300, 100, 30);
		limpaButton.setFont(buttonFont);
		limpaButton.setBackground(new Color(255,255,0));
		
		cancelaButton.setBounds(340, 300, 110, 30);
		cancelaButton.setFont(buttonFont);
		cancelaButton.setBackground(new Color(215, 0, 64));
		
		consultaButton.setBounds(490, 300, 120, 30);
		consultaButton.setFont(buttonFont);
		consultaButton.setBackground(new Color(0,191,255));
		
		
		//Painel
		cadastroPanel.setBounds(30, 100, 890, 400);
		cadastroPanel.setBackground(new Color(200, 200, 200));
		cadastroPanel.add(nomeLabel);
		cadastroPanel.add(numeroLabel);
		cadastroPanel.add(generoLabel);
		cadastroPanel.add(nomeTextField);
		cadastroPanel.add(numeroTextField);
		cadastroPanel.add(generoComboBox);
		cadastroPanel.add(cancelaButton);
		cadastroPanel.add(consultaButton);
		cadastroPanel.add(limpaButton);
		cadastroPanel.add(salvaButton);
		cadastroPanel.setVisible(true);
		cadastroFrame.add(cadastroPanel);
		cadastroFrame.add(tituloLabel);
		cadastroFrame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TelaCadastroCanal tela2 = new TelaCadastroCanal();
	}
}
