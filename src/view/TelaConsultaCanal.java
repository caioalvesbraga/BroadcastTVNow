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
import dao.ExceptionDAO;
import model.Canal;

public class TelaConsultaCanal implements ActionListener, MouseListener{
	private JFrame consultaFrame = new JFrame();
	private JLabel tituloLabel;
	private JLabel buscaLabel = new JLabel("Digite o Canal :");
	private JTextField buscaTextField = new JTextField();
	private JButton buscaButton = new JButton("Buscar");
	private JTable canaisTable;
	private Font padraoFonte = new Font("Bodoni MT Condensed", Font.PLAIN, 24);
	private ImageIcon iconeTVMedioImage = new ImageIcon("./tv64px.png");
	private ImageIcon iconeTVGrandeImage = new ImageIcon("./tv512px.png");
	private JPanel consultaPanel = new JPanel(null);
	private JPanel tabelaPanel = new JPanel(new GridLayout());
	private TelaCadastroCanal telaCadastroCanal = new TelaCadastroCanal();
	
	private DefaultTableModel tableModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int linha, int coluna) {
			return false;
		}
	};
	public void mostrarTela() {
			
		//Tela
		consultaFrame.setIconImage(iconeTVGrandeImage.getImage());
		consultaFrame.setTitle("Consulta de Canais");
		consultaFrame.setBounds(320, 120, 960, 640);
		consultaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		consultaFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		
		//Label
		tituloLabel = new JLabel("Consulta de Canal", iconeTVMedioImage, JLabel.CENTER);
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
		
		//Table //Tentar consertar
		tableModel.addColumn("Código");
		tableModel.addColumn("Emissora");
		tableModel.addColumn("Número");
		tableModel.addColumn("Tipo");
		canaisTable = new JTable(tableModel);
		canaisTable.setRowHeight(30);
		canaisTable.getTableHeader().setFont(padraoFonte);
		canaisTable.setFont(padraoFonte);
		canaisTable.setBackground(new Color(220, 220, 220));
		canaisTable.addMouseListener(this);
		
		//Painel
		tabelaPanel.setBounds(100, 100, 600, 350);
		tabelaPanel.setFont(padraoFonte);
		tabelaPanel.add(new JScrollPane(canaisTable));
		
		consultaPanel.setBounds(30, 100, 890, 480);
		consultaPanel.setBackground(new Color(150, 150, 150));
		consultaPanel.add(tabelaPanel);
		consultaPanel.add(buscaLabel);
		consultaPanel.add(buscaTextField);
		consultaPanel.add(buscaButton);
		
		consultaFrame.add(consultaPanel);
		consultaPanel.setVisible(true);
		consultaFrame.add(tituloLabel);
		consultaFrame.setVisible(true);
		
	}
	
	public void consultaCanal(java.awt.event.ActionEvent evt) {
		String nome = buscaTextField.getText();
		DefaultTableModel tableModel = (DefaultTableModel) canaisTable.getModel();
		tableModel.setRowCount(0);
		ControleCanal controleCanal = new ControleCanal();
		
		try {
			ArrayList <Canal> canais = controleCanal.listarCanais(nome);
			canais.forEach((Canal canal) -> {
				tableModel.addRow(new Object [] {canal.getCodCanal(),
												 canal.getEmissora(),
												 canal.getNumero(),
												 canal.getTipo()});
			});
			canaisTable.setModel(tableModel);
		} catch(ExceptionDAO e) {
			Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void canaisTableMouseClicked(java.awt.event.MouseEvent evt) {
		if(evt.getClickCount() == 2) {
			Integer codCanal = (Integer) canaisTable.getModel().getValueAt(canaisTable.getSelectedRow(), 0);
			String emissora = (String) canaisTable.getModel().getValueAt(canaisTable.getSelectedRow(), 1);
			Integer numero = (Integer) canaisTable.getModel().getValueAt(canaisTable.getSelectedRow(), 2);
			String tipo = (String) canaisTable.getModel().getValueAt(canaisTable.getSelectedRow(), 3);
			
			this.telaCadastroCanal.buscarCanal(codCanal, emissora, numero, tipo);
			this.telaCadastroCanal.mostrarTela();
			this.consultaFrame.dispose();;
			
		} else if(SwingUtilities.isRightMouseButton(evt)) {
			
			
		}
	}
		
	public static void main(String[] args) {
		TelaConsultaCanal tela4 = new TelaConsultaCanal();
		tela4.mostrarTela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == buscaButton) {
			consultaCanal(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if(src == canaisTable) {
			canaisTableMouseClicked(e);
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
