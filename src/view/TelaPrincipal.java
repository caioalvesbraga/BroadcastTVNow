package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class TelaPrincipal {
	private JFrame mainTela = new JFrame();
	private JPanel topPainel = new JPanel();
	private JPanel bottomPainel = new JPanel();
	private JButton favoritosButton = new JButton("Favoritos");
	private JButton canaisButton = new JButton("Canais");
	private JTextField programasDropdown;
	
	public TelaPrincipal() {
		mainTela.setBounds(320, 120, 960, 640);
		mainTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Painel Top
		topPainel.setSize(960, 60);
		topPainel.setBackground(Color.BLACK);
		
		//Painel Bottom
		bottomPainel.setSize(750, 100);
		bottomPainel.setBackground(Color.LIGHT_GRAY);
		
		
		//Botoes
		Dimension buttonSize = new Dimension(200, 30);
		canaisButton.setPreferredSize(buttonSize);
		topPainel.add(canaisButton);
		favoritosButton.setPreferredSize(buttonSize);
		topPainel.add(favoritosButton);
		
		
		//Dropdown
		String[] programas = {"Batman", "Avengers", "Star Wars", "Star Trek"};
		programasDropdown = new JTextField();
		
		programasDropdown.setPreferredSize(buttonSize);
		topPainel.add(programasDropdown);
		
		//Final
		topPainel.setVisible(true);
		mainTela.add(topPainel);
		mainTela.add(bottomPainel);
		mainTela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaPrincipal tela2 = new TelaPrincipal();
	}
}
