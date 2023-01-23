package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastroPrograma implements ActionListener{
	private JFrame cadastroFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel nomeLabel = new JLabel("Nome");
	private JLabel classificacaoIndicativaLabel = new JLabel("Classificação");
	private JLabel horarioLabel = new JLabel("Horário");
	private JLabel generoLabel = new JLabel("Gênero");
	private JLabel duracaoLabel = new JLabel("Duração");
	private JLabel canalLabel = new JLabel("Canal");
	private JTextField nomeTextField = new JTextField();
	private JTextField horarioTextField = new JTextField();
	private JTextField duracaoTextField = new JTextField();
	private JComboBox canalComboBox;
	private JComboBox classificacaoComboBox;
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
	
	public TelaCadastroPrograma() {
		
		//Tela
		cadastroFrame.setIconImage(iconeTVGrandeImage.getImage());
		cadastroFrame.setTitle("Cadastro de Canais");
		cadastroFrame.setBounds(320, 120, 960, 640);
		cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		
		//Label
		tituloLabel = new JLabel("Cadastro de Programa", iconeTVMedioImage, JLabel.CENTER);
		tituloLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
		tituloLabel.setForeground(Color.WHITE);
		tituloLabel.setVerticalAlignment(SwingConstants.TOP);
		
		nomeLabel.setFont(padraoFonte);
		Dimension nomeSize = nomeLabel.getPreferredSize();
		nomeLabel.setBounds(80, 30, nomeSize.width, nomeSize.height);
		
		classificacaoIndicativaLabel.setFont(padraoFonte);
		Dimension classificacaoSize = classificacaoIndicativaLabel.getPreferredSize();
		classificacaoIndicativaLabel.setBounds(40, 90, classificacaoSize.width + 20, classificacaoSize.height);
		
		horarioLabel.setFont(padraoFonte);
		Dimension horarioSize = horarioLabel.getPreferredSize();
		horarioLabel.setBounds(70, 150, horarioSize.width, horarioSize.height);
		
		generoLabel.setFont(padraoFonte);
		Dimension generoSize = generoLabel.getPreferredSize();
		generoLabel.setBounds(80, 210, generoSize.width, generoSize.height);
		
		duracaoLabel.setFont(padraoFonte);
		Dimension duracaoSize = duracaoLabel.getPreferredSize();
		duracaoLabel.setBounds(75, 270, duracaoSize.width+10, duracaoSize.height);
		
		canalLabel.setFont(padraoFonte);
		Dimension descricaoSize = canalLabel.getPreferredSize();
		canalLabel.setBounds(85, 330, descricaoSize.width+10, descricaoSize.height);
		
		//Text Field
		nomeTextField.setBounds(150, 30, 300, 30);
		nomeTextField.setFont(padraoFonte);
	
		
		
		horarioTextField.setBounds(150, 150, 60, 30);
		horarioTextField.setFont(padraoFonte);
		
		duracaoTextField.setBounds(150, 270, 80, 30);
		duracaoTextField.setFont(padraoFonte);
		
		
		//ComboBox
		String[] indicacoes = {"Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos"};
		classificacaoComboBox = new JComboBox(indicacoes);
		classificacaoComboBox.setBounds(150, 90, 100, 30);
		classificacaoComboBox.setFont(padraoFonte);
		
		String [] generos = {"Filme", "Seriado", "Telejornal" };
		generoComboBox = new JComboBox(generos);
		generoComboBox.setBounds(150, 210, 100, 30);
		generoComboBox.setFont(padraoFonte);
		
	
		
		String[] canais = {"Globo", "MTV", "CNN"};
		canalComboBox = new JComboBox(canais);
		canalComboBox.setBounds(150, 330, 100, 30);
		canalComboBox.setFont(padraoFonte);
		
		
		//Buttons
		salvaButton.setBounds(60, 410, 100, 30);
		salvaButton.setFont(buttonFont);
		salvaButton.setBackground(new Color(60,179,113));
		
		limpaButton.setBounds(200, 410, 100, 30);
		limpaButton.setFont(buttonFont);
		limpaButton.setBackground(new Color(255,255,0));
		
		cancelaButton.setBounds(340, 410, 110, 30);
		cancelaButton.setFont(buttonFont);
		cancelaButton.setBackground(new Color(215, 0, 64));
		
		consultaButton.setBounds(490, 410, 120, 30);
		consultaButton.setFont(buttonFont);
		consultaButton.setBackground(new Color(0,191,255));
		
		consultaButton.addActionListener(this);
		
		
		//Painel
		cadastroPanel.setBounds(30, 100, 890, 470);
		cadastroPanel.setBackground(new Color(200, 200, 200));
		cadastroPanel.add(nomeLabel);
		cadastroPanel.add(classificacaoIndicativaLabel);
		cadastroPanel.add(generoLabel);
		cadastroPanel.add(horarioLabel);
		cadastroPanel.add(duracaoLabel);
		cadastroPanel.add(canalLabel);
		cadastroPanel.add(nomeTextField);
		cadastroPanel.add(horarioTextField);
		cadastroPanel.add(duracaoTextField);
		cadastroPanel.add(canalComboBox);
		cadastroPanel.add(classificacaoComboBox);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == consultaButton) {
			new TelaConsultaPrograma();
		}
		
	}
}
