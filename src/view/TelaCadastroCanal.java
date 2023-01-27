package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.ControleCanal;
import dao.ExceptionDAO;

public class TelaCadastroCanal implements ActionListener {
	private JFrame cadastroFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel emissoraLabel = new JLabel("Emissora");
	private JLabel numeroLabel = new JLabel("Número");
	private JLabel tipoLabel = new JLabel("Tipo");
	private JTextField emissoraTextField = new JTextField();
	private JTextField numeroTextField = new JTextField("0");
	private String [] tipos = {"Cinematográfico", "Esportivo", "Jornalístico", "Musical", "Religioso", "Variedades"};
	private JComboBox tipoComboBox = new JComboBox(tipos);
	private JButton apagaButton = new JButton("Apagar");
	private JButton consultaButton = new JButton("Consultar");
	private JButton limpaButton = new JButton("Limpar");
	private JButton salvaButton = new JButton("Salvar");
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private Font buttonFont = new Font("Bodoni MT Condensed", Font.BOLD, 26);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel cadastroPanel = new JPanel(null);
	
	//Atributo oculto
	private Integer codCanal = 0;
	
	
	public void mostrarTela() {
		
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
		
		emissoraLabel.setFont(padraoFonte);
		Dimension nomeSize = emissoraLabel.getPreferredSize();
		emissoraLabel.setBounds(75, 80, nomeSize.width+10, nomeSize.height);
		
		numeroLabel.setFont(padraoFonte);
		Dimension numeroSize = numeroLabel.getPreferredSize();
		numeroLabel.setBounds(80, 150, numeroSize.width, numeroSize.height);
		
		tipoLabel.setFont(padraoFonte);
		Dimension generoSize = tipoLabel.getPreferredSize();
		tipoLabel.setBounds(80, 220, generoSize.width, generoSize.height);
		
		//Text Field
		emissoraTextField.setBounds(150, 80, 300, 30);
		emissoraTextField.setFont(padraoFonte);
	
		numeroTextField.setBounds(150, 150, 40, 30);
		numeroTextField.setFont(padraoFonte);
		
		//ComboBox
		tipoComboBox.setBounds(150, 220, 150, 30);
		tipoComboBox.setFont(padraoFonte);
		tipoComboBox.addActionListener(this);
		
		//Buttons
		
		salvaButton.setBounds(60, 300, 100, 30);
		salvaButton.setFont(buttonFont);
		salvaButton.setBackground(new Color(60,179,113));
		
		salvaButton.addActionListener(this);
		
		limpaButton.setBounds(200, 300, 100, 30);
		limpaButton.setFont(buttonFont);
		limpaButton.setBackground(new Color(255,255,0));
		
		limpaButton.addActionListener(this);
		
		apagaButton.setBounds(340, 300, 110, 30);
		apagaButton.setFont(buttonFont);
		apagaButton.setBackground(new Color(215, 0, 64));
		
		apagaButton.addActionListener(this);
		
		consultaButton.setBounds(490, 300, 120, 30);
		consultaButton.setFont(buttonFont);
		consultaButton.setBackground(new Color(0,191,255));
		
		consultaButton.addActionListener(this);
		
		
		//Painel
		cadastroPanel.setBounds(30, 100, 890, 400);
		cadastroPanel.setBackground(new Color(200, 200, 200));
		cadastroPanel.add(emissoraLabel);
		cadastroPanel.add(numeroLabel);
		cadastroPanel.add(tipoLabel);
		cadastroPanel.add(emissoraTextField);
		cadastroPanel.add(numeroTextField);
		cadastroPanel.add(tipoComboBox);
		cadastroPanel.add(apagaButton);
		cadastroPanel.add(consultaButton);
		cadastroPanel.add(limpaButton);
		cadastroPanel.add(salvaButton);
		cadastroPanel.setVisible(true);
		cadastroFrame.add(cadastroPanel);
		cadastroFrame.add(tituloLabel);
		cadastroFrame.setVisible(true);
		
	}
	
	public void limparTelaCadastroCanal(java.awt.event.ActionEvent evt) {
		emissoraTextField.setText("");
		numeroTextField.setText("");
		tipoComboBox.setSelectedIndex(0);
	}
	
	public void apagarCanal(java.awt.event.ActionEvent evt) {
		boolean sucesso = false;
		ControleCanal controleCanal = new ControleCanal();
		try {
			sucesso = controleCanal.apagarCanal(this.codCanal);
			if(sucesso) {
				JOptionPane.showMessageDialog(null,"Canal apagado com sucesso!");
				this.limparTelaCadastroCanal(evt);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao apagar canal. Por favor, selecione um canal");
			}
		} catch (ExceptionDAO ex) {
			Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void buscarCanal(Integer codCanal, String emissora, Integer numero, String tipo) {
		this.codCanal = codCanal;
		this.emissoraTextField.setText(emissora);
		this.numeroTextField.setText(numero.toString());
		for(int contador = 0; contador < tipoComboBox.getItemCount(); contador++) {
			if(tipoComboBox.getItemAt(contador).equals(tipo))
				tipoComboBox.setSelectedIndex(contador);
		}
	}
	
	public void salvarCanal(java.awt.event.ActionEvent evt) {
		
		boolean sucesso = false;
		
		try {
			String emissora = emissoraTextField.getText();
			int numero = Integer.parseInt(numeroTextField.getText());
			String tipo = tipoComboBox.getSelectedItem().toString();
			ControleCanal controleCanal = new ControleCanal();
			if(this.codCanal == 0) {
				sucesso = controleCanal.cadastrarCanal(emissora, numero, tipo);
			} else {
				sucesso = controleCanal.alterarCanal(this.codCanal, emissora, numero, tipo);
			}
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
	
	public static void main(String[] args) {
		TelaCadastroCanal tela = new TelaCadastroCanal();
		tela.mostrarTela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == consultaButton) {
			TelaConsultaCanal telaConsulta = new TelaConsultaCanal();
			telaConsulta.mostrarTela();
		}
		
		if (src == salvaButton) {
			salvarCanal(e);
		}
		
		if (src == apagaButton) {
			apagarCanal(e);
		}
		
		if(src == limpaButton) {
			limparTelaCadastroCanal(e);
		}
		
	}
}
