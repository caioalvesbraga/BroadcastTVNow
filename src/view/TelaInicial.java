package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class TelaInicial {
	
	private JMenuBar barraDeMenu = new JMenuBar ();
	private JMenu listaMenu = new JMenu("Listar");
	private JMenu cadastroMenu = new JMenu("Cadastro");
	private JMenuItem canaisItem = new JMenuItem("Canais");
	private JMenuItem programasItem = new JMenuItem("Programas");
	private JFrame telaInicialFrame = new JFrame();
	private JPanel inicialPanel = new JPanel();
	private JLabel boasVindasText = new JLabel();
	private ImageIcon iconeTVImage = new ImageIcon("./tv512px.png");
	private JLabel iconeTVLabel = new JLabel(new ImageIcon("./tv128px.png"));
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	
	
	public TelaInicial() {
		
		//Barra de Menu
		cadastroMenu.add(canaisItem); cadastroMenu.add(programasItem);
		barraDeMenu.add(listaMenu);
		barraDeMenu.add(cadastroMenu);
		barraDeMenu.setBackground(Color.LIGHT_GRAY);
		barraDeMenu.setPreferredSize(new Dimension(960, 50));
		
		listaMenu.setPreferredSize(new Dimension(100,50));
		cadastroMenu.setPreferredSize(new Dimension(100,50));
		
		canaisItem.setFont(padraoFonte);
		programasItem.setFont(padraoFonte);
		cadastroMenu.setFont(padraoFonte);
		listaMenu.setFont(padraoFonte);
		
		telaInicialFrame.setJMenuBar(barraDeMenu);
		
		
		//Tela
		telaInicialFrame.setIconImage(iconeTVImage.getImage());
		telaInicialFrame.setTitle("BroadcastTV Now");
		telaInicialFrame.setBounds(320, 120, 960, 640);
		inicialPanel.setBackground(new Color(30, 30, 30));
		telaInicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicialPanel.setVisible(true);
		
		//GridBagLayout
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		inicialPanel.setLayout(layout);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//Labels
		boasVindasText.setText("<html><p style =\"text-align:center; \">Bem-vindo ao <br> BroadcastTV Now</p></html>");
		boasVindasText.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 72));
		boasVindasText.setForeground(Color.white);
		inicialPanel.add(boasVindasText, constraints);
		
		//Icone
		constraints.gridy = 1;
		iconeTVLabel.setPreferredSize(new Dimension(200,200));
		inicialPanel.add(iconeTVLabel, constraints);
		
		//Final
		telaInicialFrame.add(inicialPanel);
		telaInicialFrame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		TelaInicial tela1 = new TelaInicial();
		
	}
}


