package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaDetalhePrograma implements ActionListener{
	private JPanel detalhePanel = new JPanel(null);
	private JFrame detalheFrame = new JFrame();
	private JLabel tituloDialogLabel;
	private JLabel input1Label;
	private JLabel input2Label;
	private JTextField input1TextField = new JTextField(0);
	private JTextField input2TextField = new JTextField(0);
	private JComboBox input1ComboBox;
	private JButton enviaButton = new JButton("Enviar");
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private Font buttonFont = new Font("Bodoni MT Condensed", Font.BOLD, 26);
	
	
	public void mostrarTela(int op) {
		switch(op) {
		case 1:
			
			//Tela
			detalheFrame.setIconImage(iconeTVGrandeImage.getImage());
			detalheFrame.setTitle("Detalhar Programa");
			detalheFrame.setBounds(480, 150, 600, 500);
			detalheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			detalheFrame.getContentPane().setBackground(new Color(30, 30, 30));
			
			//Label
			tituloDialogLabel = new JLabel("Detalhar Programa", iconeTVMedioImage, JLabel.CENTER);
			tituloDialogLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
			tituloDialogLabel.setForeground(Color.WHITE);
			tituloDialogLabel.setVerticalAlignment(SwingConstants.TOP);
			
			input1Label = new JLabel("Avaliação");
			input1Label.setFont(padraoFonte);
			Dimension input1Size = input1Label.getPreferredSize();
			input1Label.setBounds(80, 80, input1Size.width, input1Size.height);
			
			input2Label = new JLabel("Bilheteria");
			input2Label.setFont(padraoFonte);
			Dimension input2Size = input2Label.getPreferredSize();
			input2Label.setBounds(80, 150, input2Size.width, input2Size.height);
			
			//Text Field
			String [] estrelas = { "1", "2", "3", "4", "5"};
			input1ComboBox = new JComboBox(estrelas);
			input1ComboBox.setBounds(180, 80, 100, 30);
			DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
			listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
			input1ComboBox.setRenderer(listRenderer);
			input1ComboBox.setFont(padraoFonte);
			
			input2TextField.setBounds(180, 150, 200, 30);
			input2TextField.setFont(padraoFonte);
			
			//Buttons
			enviaButton.setBounds(220, 220, 100, 30);
			enviaButton.setFont(buttonFont);
			enviaButton.setBackground(new Color(60,179,113));
			
			enviaButton.addActionListener(this);
			
			//Painel
			detalhePanel.setBounds(30, 100, 530, 300);
			detalhePanel.setBackground(new Color(200, 200, 200));
			detalhePanel.add(input1Label);
			detalhePanel.add(input2Label);
			detalhePanel.add(input1ComboBox);
			detalhePanel.add(input2TextField);
			detalhePanel.add(enviaButton);
			detalhePanel.setVisible(true);
			detalheFrame.add(detalhePanel);
			detalheFrame.add(tituloDialogLabel);
			detalheFrame.setVisible(true);
			break;
			
		case 2:
			
			//Tela
			detalheFrame.setIconImage(iconeTVGrandeImage.getImage());
			detalheFrame.setTitle("Detalhar Programa");
			detalheFrame.setBounds(480, 150, 600, 500);
			detalheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			detalheFrame.getContentPane().setBackground(new Color(30, 30, 30));
			
			//Label
			tituloDialogLabel = new JLabel("Detalhar Programa", iconeTVMedioImage, JLabel.CENTER);
			tituloDialogLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
			tituloDialogLabel.setForeground(Color.WHITE);
			tituloDialogLabel.setVerticalAlignment(SwingConstants.TOP);
			
			input1Label = new JLabel("Quantidade de Episódios");
			input1Label.setFont(padraoFonte);
			Dimension input1Size2 = input1Label.getPreferredSize();
			input1Label.setBounds(85, 80, input1Size2.width, input1Size2.height);
			
			input2Label = new JLabel("Quantidade de Temporadas");
			input2Label.setFont(padraoFonte);
			Dimension input2Size2 = input2Label.getPreferredSize();
			input2Label.setBounds(80, 150, input2Size2.width, input2Size2.height);
			
			//Text Field
			
			input1TextField.setBounds(280, 80, 40, 30);
			input1TextField.setFont(padraoFonte);
			
			input2TextField.setBounds(280, 150, 40, 30);
			input2TextField.setFont(padraoFonte);
			
			//Buttons
			enviaButton.setBounds(220, 220, 100, 30);
			enviaButton.setFont(buttonFont);
			enviaButton.setBackground(new Color(60,179,113));
			
			enviaButton.addActionListener(this);
			
			//Painel
			detalhePanel.setBounds(30, 100, 530, 300);
			detalhePanel.setBackground(new Color(200, 200, 200));
			detalhePanel.add(input1Label);
			detalhePanel.add(input2Label);
			detalhePanel.add(input1TextField);
			detalhePanel.add(input2TextField);
			detalhePanel.add(enviaButton);
			detalhePanel.setVisible(true);
			detalheFrame.add(detalhePanel);
			detalheFrame.add(tituloDialogLabel);
			detalheFrame.setVisible(true);
			break;
			
		case 3:
			
			//Tela
			detalheFrame.setIconImage(iconeTVGrandeImage.getImage());
			detalheFrame.setTitle("Detalhar Programa");
			detalheFrame.setBounds(480, 150, 600, 500);
			detalheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			detalheFrame.getContentPane().setBackground(new Color(30, 30, 30));
			
			//Label
			tituloDialogLabel = new JLabel("Detalhar Programa", iconeTVMedioImage, JLabel.CENTER);
			tituloDialogLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
			tituloDialogLabel.setForeground(Color.WHITE);
			tituloDialogLabel.setVerticalAlignment(SwingConstants.TOP);
			
			input1Label = new JLabel("Apresentadores");
			input1Label.setFont(padraoFonte);
			Dimension input1Size3 = input1Label.getPreferredSize();
			input1Label.setBounds(75, 80, input1Size3.width + 10, input1Size3.height);
			
			input2Label = new JLabel("Tipo de Jornal");
			input2Label.setFont(padraoFonte);
			Dimension input2Size3 = input2Label.getPreferredSize();
			input2Label.setBounds(80, 150, input2Size3.width, input2Size3.height);
			
			//Text Field
			
			input1TextField.setBounds(200, 80, 280, 30);
			input1TextField.setFont(padraoFonte);
			
			String[] tipoDeJornal = {"Automobilístico", "Esportivo", "Informativo", "Tecnológico"};
			input1ComboBox = new JComboBox(tipoDeJornal);
			input1ComboBox.setBounds(200, 150, 150, 30);
			input1ComboBox.setFont(padraoFonte);
			
			//Buttons
			enviaButton.setBounds(220, 220, 100, 30);
			enviaButton.setFont(buttonFont);
			enviaButton.setBackground(new Color(60,179,113));
			
			enviaButton.addActionListener(this);
			
			//Painel
			detalhePanel.setBounds(30, 100, 530, 300);
			detalhePanel.setBackground(new Color(200, 200, 200));
			detalhePanel.add(input1Label);
			detalhePanel.add(input2Label);
			detalhePanel.add(input1TextField);
			detalhePanel.add(input1ComboBox);
			detalhePanel.add(enviaButton);
			detalhePanel.setVisible(true);
			detalheFrame.add(detalhePanel);
			detalheFrame.add(tituloDialogLabel);
			detalheFrame.setVisible(true);
			break;
		}
	}
	
	public String getInput1TextField() {
		return input1TextField.getText();
	}
	public String getInput2TextField() {
		return input2TextField.getText();
	}
	public String getInput1ComboBox() {
		return input1ComboBox.getSelectedItem().toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == enviaButton) {
			TelaCadastroPrograma.Instancia.setInput1(input1TextField.getText());
			TelaCadastroPrograma.Instancia.setInput2(input2TextField.getText());
			TelaCadastroPrograma.Instancia.setInput3(input1ComboBox.getSelectedItem().toString());
			TelaCadastroPrograma.Instancia.salvarPrograma(e);
			detalheFrame.dispose();
		}
		
	}
}
