package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControleCanal;
import controller.ControleFilme;
import controller.ControleSeriado;
import controller.ControleTelejornal;
import dao.ExceptionDAO;
import model.Canal;
import model.Filme;
import model.Seriado;
import model.Telejornal;

public class TelaConsultaPrograma implements ActionListener, MouseListener {
	
	private JFrame consultaFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel buscaLabel = new JLabel("Digite o Programa :");
	private JTextField buscaTextField = new JTextField();
	private JButton buscaButton = new JButton("Buscar");
	private JTable programasTable;
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel consultaPanel = new JPanel(null);
	private JPanel tabelaPanel = new JPanel(new GridLayout());
	private TelaCadastroPrograma telaCadastroPrograma = new TelaCadastroPrograma();
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int linha, int coluna) {
			return false;
		}
	};
	private String tipoBusca;
	
	public TelaConsultaPrograma(String tipoBusca) {
		this.tipoBusca = tipoBusca;
	}
		
	/**
	 * 
	 */
	public void mostrarTela() {
			
		//Tela
		consultaFrame.setIconImage(iconeTVGrandeImage.getImage());
		consultaFrame.setTitle("Consulta de Programa");
		consultaFrame.setBounds(320, 120, 960, 640);
		consultaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		consultaFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		
		//Label
		tituloLabel = new JLabel("Consulta de Programa", iconeTVMedioImage, JLabel.CENTER);
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
		buscaButton.addActionListener(this);
		
		//List
		tableModel.addColumn("Código");
		tableModel.addColumn("Canal");
		tableModel.addColumn("Classificação");
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Tipo");
		tableModel.addColumn("Título");
		tableModel.addColumn("Horário");
		programasTable = new JTable(tableModel);
		programasTable.setFont(padraoFonte);
		programasTable.setRowHeight(30);
		programasTable.getTableHeader().setFont(padraoFonte);
		programasTable.setBackground(new Color(220, 220, 220));
		programasTable.addMouseListener(this);
		
		
		//Painel
		tabelaPanel.setBounds(60, 100, 670, 350);
		tabelaPanel.setFont(padraoFonte);
		tabelaPanel.add(new JScrollPane(programasTable));
		
		
		consultaPanel.setBounds(30, 100, 890, 480);
		consultaPanel.setBackground(new Color(150, 150, 150));
		consultaPanel.add(buscaLabel);
		consultaPanel.add(buscaTextField);
		consultaPanel.add(buscaButton);
		consultaPanel.add(tabelaPanel);
		
		consultaFrame.add(consultaPanel);
		consultaPanel.setVisible(true);
		consultaFrame.add(tituloLabel);
		consultaFrame.setVisible(true);
		
	}
	
	public void listarProgramaPorTitulo(java.awt.event.ActionEvent evt) {
		String nome = buscaTextField.getText();
		DefaultTableModel tableModel = (DefaultTableModel) programasTable.getModel();
		tableModel.setRowCount(0);
		ControleFilme controleFilme = new ControleFilme();
		ControleSeriado controleSeriado = new ControleSeriado();
		ControleTelejornal controleTelejornal = new ControleTelejornal();
		
		try {
			ArrayList <Filme> filmes = controleFilme.listarFilmePorTitulo(nome);
			ArrayList <Seriado> seriados = controleSeriado.listarSeriadoPorTitulo(nome);
			ArrayList <Telejornal> telejornais = controleTelejornal.listarTelejornalPorTitulo(nome);
			filmes.forEach((Filme filme) -> {
				tableModel.addRow(new Object [] {filme.getCodFilme(),
												 filme.getCanal(),
												 filme.getClassificacao(),
												 filme.getDescricao(),
												 filme.getTipo(),
												 filme.getTitulo(),
												 filme.getHorario()});
			});
			seriados.forEach((Seriado seriado) -> {
				tableModel.addRow(new Object[] {seriado.getCodSeriado(),
												seriado.getCanal(),
												seriado.getClassificacao(),
												seriado.getDescricao(),
												seriado.getTipo(),
												seriado.getTitulo(),
												seriado.getHorario()});
			});
			programasTable.setModel(tableModel);
			
			telejornais.forEach((Telejornal telejornal) -> {
				tableModel.addRow(new Object[] {telejornal.getCodTelejornal(),
												telejornal.getCanal(),
												telejornal.getClassificacao(),
												telejornal.getDescricao(),
												telejornal.getTipo(),
												telejornal.getTitulo(),
												telejornal.getHorario()});
			});
			programasTable.setModel(tableModel);
		} catch(ExceptionDAO e) {
			Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void listarProgramaPorCanal(java.awt.event.ActionEvent evt) {
		String nome = buscaTextField.getText();
		DefaultTableModel tableModel = (DefaultTableModel) programasTable.getModel();
		tableModel.setRowCount(0);
		ControleFilme controleFilme = new ControleFilme();
		ControleSeriado controleSeriado = new ControleSeriado();
		ControleTelejornal controleTelejornal = new ControleTelejornal();
		
		try {
			ArrayList <Filme> filmes = controleFilme.listarFilmePorCanal(nome);
			ArrayList <Seriado> seriados = controleSeriado.listarSeriadoPorCanal(nome);
			ArrayList <Telejornal> telejornais = controleTelejornal.listarTelejornalPorCanal(nome);
			filmes.forEach((Filme filme) -> {
				tableModel.addRow(new Object [] {filme.getCodFilme(),
												 filme.getCanal(),
												 filme.getClassificacao(),
												 filme.getDescricao(),
												 filme.getTipo(),
												 filme.getTitulo(),
												 filme.getHorario()});
			});
			seriados.forEach((Seriado seriado) -> {
				tableModel.addRow(new Object[] {seriado.getCodSeriado(),
												seriado.getCanal(),
												seriado.getClassificacao(),
												seriado.getDescricao(),
												seriado.getTipo(),
												seriado.getTitulo(),
												seriado.getHorario()});
			});
			programasTable.setModel(tableModel);
			
			telejornais.forEach((Telejornal telejornal) -> {
				tableModel.addRow(new Object[] {telejornal.getCodTelejornal(),
												telejornal.getCanal(),
												telejornal.getClassificacao(),
												telejornal.getDescricao(),
												telejornal.getTipo(),
												telejornal.getTitulo(),
												telejornal.getHorario()});
			});
			programasTable.setModel(tableModel);
		} catch(ExceptionDAO e) {
			Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void programasTableFilmeMouseClicked(java.awt.event.MouseEvent evt) throws ExceptionDAO {
		if(evt.getClickCount() == 2) {
			Integer codFilme = (Integer) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 0);
			String canal = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 1);
			String classificacao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 2);
			String descricao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 3);
			String tipo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 4);
			String titulo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 5);
			String horario = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 6);
			
			this.telaCadastroPrograma.preparaFilme(codFilme, canal, classificacao, descricao, tipo,  titulo, horario);
			this.telaCadastroPrograma.mostrarTela();
			this.consultaFrame.dispose();;
			
		} 
	}
	
	public void programasTableSeriadoMouseClicked(java.awt.event.MouseEvent evt) throws ExceptionDAO {
		if(evt.getClickCount() == 2) {
			Integer codSeriado = (Integer) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 0);
			String canal = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 1);
			String classificacao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 2);
			String descricao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 3);
			String tipo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 4);
			String titulo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 5);
			String horario = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 6);
			
			this.telaCadastroPrograma.preparaSeriado(codSeriado, canal, classificacao, descricao, tipo,  titulo, horario);
			this.telaCadastroPrograma.mostrarTela();
			this.consultaFrame.dispose();;
			
		} 
	}
	
	public void programasTableTelejornalMouseClicked(java.awt.event.MouseEvent evt) throws ExceptionDAO {
		if(evt.getClickCount() == 2) {
			Integer codTelejornal = (Integer) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 0);
			String canal = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 1);
			String classificacao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 2);
			String descricao = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 3);
			String tipo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 4);
			String titulo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 5);
			String horario = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 6);
			
			this.telaCadastroPrograma.preparaTelejornal(codTelejornal, canal, classificacao, descricao, tipo,  titulo, horario);
			this.telaCadastroPrograma.mostrarTela();
			this.consultaFrame.dispose();;
			
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == buscaButton) {
			if(this.tipoBusca.equals("Busca por Canal")) {
				listarProgramaPorCanal(e);
			} else {
				listarProgramaPorTitulo(e);
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		String tipo = (String) programasTable.getModel().getValueAt(programasTable.getSelectedRow(), 4);
		if(src == programasTable) {
			try {
				if(tipo == "Filme") {
					programasTableFilmeMouseClicked(e);
				} else if(tipo == "Seriado") {
					programasTableSeriadoMouseClicked(e);
				} else  {
					programasTableTelejornalMouseClicked(e);
				}
				
				
			} catch (ExceptionDAO e1) {
				e1.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
