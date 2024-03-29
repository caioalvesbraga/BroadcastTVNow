package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import dao.ExceptionDAO;

/**
 * A classe TelaInicial é responsável pela criação da primeira interface gráfica que será disponibilizada para 
 * o usuário
 * @author Caio Alves Braga
 *
 */
public class TelaInicial implements ActionListener{
	
	private JMenuBar barraDeMenu = new JMenuBar ();
	private	JMenu programacaoMenu = new JMenu("Programação");
	private JMenu cadastroMenu = new JMenu("Cadastro");
	private JMenuItem canaisItem = new JMenuItem("Canais");
	private JMenuItem listaItem = new JMenuItem("Listar");
	private JMenuItem programasItem = new JMenuItem("Programas");
	private JFrame telaInicialFrame = new JFrame();
	private JPanel inicialPanel = new JPanel();
	private JLabel boasVindasText = new JLabel();
	private ImageIcon iconeTVImage = new ImageIcon("./tv512px.png");
	private JLabel iconeTVLabel = new JLabel(new ImageIcon("./tv128px.png"));
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	
	/**
	 * O Construtor TelaInicial define as características da tela inicial
	 */
	public TelaInicial() {
		
		//Barra de Menu
		barraDeMenu.add(programacaoMenu);
		barraDeMenu.add(cadastroMenu);
		barraDeMenu.setBackground(Color.LIGHT_GRAY);
		barraDeMenu.setPreferredSize(new Dimension(960, 50));
		
		programacaoMenu.setPreferredSize(new Dimension(120,50));
		cadastroMenu.setPreferredSize(new Dimension(100,50));
		
		canaisItem.setFont(padraoFonte);
		canaisItem.setPreferredSize(new Dimension(98,50));
		canaisItem.addActionListener(this);
		
		programasItem.setFont(padraoFonte);
		programasItem.addActionListener(this);
		
		listaItem.setFont(padraoFonte);
		listaItem.setPreferredSize(new Dimension(118, 50));
		listaItem.addActionListener(this);
		
		cadastroMenu.setFont(padraoFonte);
		programacaoMenu.setFont(padraoFonte);
		
		cadastroMenu.add(canaisItem); cadastroMenu.add(programasItem);
		programacaoMenu.add(listaItem);
		
		telaInicialFrame.setJMenuBar(barraDeMenu);
		
		
		//Tela
		telaInicialFrame.setIconImage(iconeTVImage.getImage());
		telaInicialFrame.setTitle("BroadcastTV Now");
		telaInicialFrame.setBounds(320, 120, 960, 640);
		inicialPanel.setBackground(new Color(30, 30, 30));
		telaInicialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
	/**
	 * O método main é responsável por executar a aplicação
	 * @param args
	 */
	public static void main(String[] args) {
		TelaInicial tela1 = new TelaInicial();
		
	}
	
	/**
	 * O método actionPerfomed define os eventos da tela inicial
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == canaisItem) {
			TelaCadastroCanal telaCadastroC = new TelaCadastroCanal();
			telaCadastroC.mostrarTela();
		} else if(src == programasItem) {
			TelaCadastroPrograma telaCadastroP = new TelaCadastroPrograma();
			try {
				telaCadastroP.mostrarTela();
			} catch (ExceptionDAO e1) {
				e1.printStackTrace();
			}
		} else if(src == listaItem) {
			TelaConsultaPrograma telaConsultaPrograma = new TelaConsultaPrograma("Busca por Canal");
			telaConsultaPrograma.mostrarTela();
		}
		
	}
}


