package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class TelaInicial {
	
	private JFrame tela = new JFrame();
	private JPanel painel = new JPanel();
	private JLabel boasVindasText = new JLabel("Bem-vindos ao BroadcastTV Now");
	private JLabel rotuloText = new JLabel("Insira seu nome aqui: ");
	private JTextField campoNome = new JTextField();
	private JButton botaoEntrar = new JButton("Entrar");
	
	public TelaInicial() {
		
		//Tela
		tela.setBounds(320, 120, 960, 640);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setVisible(true);
		painel.setLayout(new GridBagLayout());
		GridBagConstraints organizadores = new GridBagConstraints();
		organizadores.gridx = 0;
		organizadores.gridy = 0;
		organizadores.insets = new Insets(10,0,30,0);
		organizadores.anchor = GridBagConstraints.CENTER;
		
		//Labels
		organizadores.gridy = 0;
		boasVindasText.setFont(new Font("Arial", Font.PLAIN, 52));
		painel.add(boasVindasText, organizadores);
		organizadores.gridy = 1;
		rotuloText.setFont(new Font("Arial", Font.PLAIN, 18));
		painel.add(rotuloText, organizadores);
		
		//TextField
		campoNome.setPreferredSize(new Dimension(650, 30));
		organizadores.gridy = 2;
		painel.add(campoNome, organizadores);
		
		//Botões
		botaoEntrar.setPreferredSize(new Dimension(310, 35));
		organizadores.gridy = 3;
		painel.add(botaoEntrar, organizadores);
		tela.add(painel);
		tela.setVisible(true);	
	}
	
	public static void main(String[] args) {
		TelaInicial tela1 = new TelaInicial();
		
	}
}


