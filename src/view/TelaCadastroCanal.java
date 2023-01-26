package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.ControleCanal;

public class TelaCadastroCanal implements ActionListener {
	private JFrame cadastroFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel nomeLabel = new JLabel("Nome");
	private JLabel numeroLabel = new JLabel("Número");
	private JLabel generoLabel = new JLabel("Gênero");
	private JTextField nomeTextField = new JTextField();
	private JTextField numeroTextField = new JTextField("0");
	private JComboBox generoComboBox;
	private JButton cancelaButton = new JButton("Cancelar");
	private JButton consultaButton = new JButton("Consultar");
	private JButton limpaButton = new JButton("Limpar");
	private static JButton salvaButton = new JButton("Salvar");
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
		cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		salvaButton.addActionListener(this);
		
		limpaButton.setBounds(200, 300, 100, 30);
		limpaButton.setFont(buttonFont);
		limpaButton.setBackground(new Color(255,255,0));
		
		cancelaButton.setBounds(340, 300, 110, 30);
		cancelaButton.setFont(buttonFont);
		cancelaButton.setBackground(new Color(215, 0, 64));
		
		consultaButton.setBounds(490, 300, 120, 30);
		consultaButton.setFont(buttonFont);
		consultaButton.setBackground(new Color(0,191,255));
		
		consultaButton.addActionListener(this);
		
		
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
	
	public void limparTelaCadastroCanal(java.awt.event.ActionEvent evt) {
		nomeTextField.setText("");
		numeroTextField.setText("");
		generoComboBox.setSelectedIndex(0);
	}
	
	public void salvarCanal(java.awt.event.ActionEvent evt) {
		
		boolean sucesso;
		
		try {
			int numero = Integer.parseInt(numeroTextField.getText());
			String tipo = generoComboBox.getSelectedItem().toString();
			ControleCanal controleCanal = new ControleCanal();
			sucesso = controleCanal.cadastrarCanal(nomeTextField.getText(), numero, tipo);
			if(sucesso == true) {
				JOptionPane.showMessageDialog(null, "O cadastro "
						+ "foi realizado com sucesso!");
				this.limparTelaCadastroCanal(evt);
			} else {
				JOptionPane.showMessageDialog(null, "Os campos não "
						+ "foram preenchidos corretamente.");
			}
		} catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Erro" + ex);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == consultaButton) {
			new TelaConsultaCanal();
		}
		
		if (src == salvaButton) {
			salvarCanal(e);
		}
		
	}
}
