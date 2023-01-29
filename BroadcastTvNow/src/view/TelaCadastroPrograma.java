package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControleCanal;
import controller.ControleFilme;
import controller.ControleSeriado;
import controller.ControleTelejornal;
import dao.ExceptionDAO;
import model.Canal;

/**
 * A classe TelaCadastroPrograma cria a interface gráfica para cadastrar programas
 * @author Caio Alves Braga
 *
 */
public class TelaCadastroPrograma implements ActionListener{
	private JFrame cadastroFrame = new JFrame();
	private JLabel tituloFrameLabel;
	private JLabel tituloLabel = new JLabel("Título");
	private JLabel classificacaoIndicativaLabel = new JLabel("Classificação");
	private JLabel horarioLabel = new JLabel("Horário");
	private JLabel generoLabel = new JLabel("Gênero");
	private JLabel dataLabel = new JLabel("Data");
	private JLabel canalLabel = new JLabel("Canal");
	private JLabel descricaoLabel = new JLabel("Descrição");
	private MaskFormatter dataMask = null;
	private JFormattedTextField dataTextField = new JFormattedTextField("");
	private JTextArea descricaoTextArea = new JTextArea("");
	private JTextField tituloTextField = new JTextField();
	private MaskFormatter horarioMask = null;
	private JFormattedTextField horarioTextField = new JFormattedTextField("");
	
	
	private ControleCanal controle = new  ControleCanal();
	private JComboBox<Object> canalComboBox = new JComboBox<Object>();
	private ComboBoxModel<Object> defaultComboBoxModel = new DefaultComboBoxModel<Object>();{
	try {
		for(Canal canal : controle.listarCanais("")) {
			((DefaultComboBoxModel<Object>) defaultComboBoxModel).addElement((Object)canal.getEmissora());
		}
	} catch (ExceptionDAO e) {
		e.printStackTrace();
	}
	canalComboBox.setModel(defaultComboBoxModel);
	canalComboBox.setRenderer(new CanalListCellRenderer());}
	
	String[] indicacoes = {"Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos"};
	private JComboBox classificacaoComboBox = new JComboBox(indicacoes);
	
	String [] tipos = {"Filme", "Seriado", "Telejornal" };
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
	
	//Atributos necessários para o comportamento integrado à Controller
	public static TelaCadastroPrograma Instancia;
	private TelaDetalhePrograma telaDetalhe;
	public String input1;
	public String input2;
	public String input3;
	private Integer codFilme = 0;
	private Integer codSeriado = 0;
	private Integer codTelejornal = 0;
	
	/**
	 * O construtor TelaCadastroPrograma define que Intancia será a própria TelaCadastroPrograma
	 */
	public TelaCadastroPrograma() {
		Instancia = this;
	}
		
	/**
	 * O método mostrarTela define as características da tela de cadastro de programas
	 * @throws ExceptionDAO
	 */
	public void mostrarTela() throws ExceptionDAO {
		//Tela
		cadastroFrame.setIconImage(iconeTVGrandeImage.getImage());
		cadastroFrame.setTitle("Cadastro de Programas");
		cadastroFrame.setBounds(320, 120, 960, 640);
		cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroFrame.getContentPane().setBackground(new Color(30, 30, 30));
		
		tituloFrameLabel = new JLabel("Cadastro de Programa", iconeTVMedioImage, JLabel.CENTER);
		tituloFrameLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 42));
		tituloFrameLabel.setForeground(Color.WHITE);
		tituloFrameLabel.setVerticalAlignment(SwingConstants.TOP);
		
		
		//Label
		
		
		canalLabel.setFont(padraoFonte);
		Dimension canalSize = canalLabel.getPreferredSize();
		canalLabel.setBounds(85, 280, canalSize.width+10, canalSize.height);
		
		classificacaoIndicativaLabel.setFont(padraoFonte);
		Dimension classificacaoSize = classificacaoIndicativaLabel.getPreferredSize();
		classificacaoIndicativaLabel.setBounds(40, 90, classificacaoSize.width + 20, classificacaoSize.height);
		
		dataLabel.setFont(padraoFonte);
		Dimension dataSize = dataLabel.getPreferredSize();
		dataLabel.setBounds(450, 50, dataSize.width, dataSize.height);
		
		descricaoLabel.setFont(padraoFonte);
		Dimension descricaoSize = descricaoLabel.getPreferredSize();
		descricaoLabel.setBounds(420, 130, descricaoSize.width+10, descricaoSize.height);
		
		horarioLabel.setFont(padraoFonte);
		Dimension horarioSize = horarioLabel.getPreferredSize();
		horarioLabel.setBounds(70, 150, horarioSize.width, horarioSize.height);
		
		generoLabel.setFont(padraoFonte);
		Dimension generoSize = generoLabel.getPreferredSize();
		generoLabel.setBounds(80, 210, generoSize.width, generoSize.height);
		
		tituloLabel.setFont(padraoFonte);
		Dimension tituloSize = tituloLabel.getPreferredSize();
		tituloLabel.setBounds(80, 30, tituloSize.width, tituloSize.height);
		
		//Text Field
		try {
			dataMask = new MaskFormatter("##/##/####");
		} catch(Exception e) {
			System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
		}
		dataTextField = new JFormattedTextField(dataMask);
		dataTextField.setBounds(500, 50, 150, 40);
		dataTextField.setFont(padraoFonte);
		
		tituloTextField.setBounds(160, 30, 200, 30);
		tituloTextField.setFont(padraoFonte);

		try {
			horarioMask = new MaskFormatter("##:##");
		} catch(Exception e) {
			System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
		}
		horarioTextField = new JFormattedTextField(horarioMask);
		horarioTextField.setBounds(160, 150, 60, 30);
		horarioTextField.setFont(padraoFonte);
		
		
		//TextArea
		descricaoTextArea.setBounds(500, 130, 250, 150);
		descricaoTextArea.setFont(padraoFonte);
		descricaoTextArea.setLineWrap(true);
		descricaoTextArea.setWrapStyleWord(true);
		
		
		//ComboBox
		classificacaoComboBox.setBounds(160, 90, 100, 30);
		classificacaoComboBox.setFont(padraoFonte);
		
		
		tipoComboBox.setBounds(160, 210, 100, 30);
		tipoComboBox.setFont(padraoFonte);
	
		
		
		
		canalComboBox.setBounds(160, 280, 100, 30);
		canalComboBox.setFont(padraoFonte);
		
		
		//Buttons
		salvaButton.setBounds(60, 410, 100, 30);
		salvaButton.setFont(buttonFont);
		salvaButton.setBackground(new Color(60,179,113));
		salvaButton.addActionListener(this);
		
		limpaButton.setBounds(200, 410, 100, 30);
		limpaButton.setFont(buttonFont);
		limpaButton.setBackground(new Color(255,255,0));
		limpaButton.addActionListener(this);
		
		apagaButton.setBounds(340, 410, 110, 30);
		apagaButton.setFont(buttonFont);
		apagaButton.setBackground(new Color(215, 0, 64));
		apagaButton.addActionListener(this);
		
		consultaButton.setBounds(490, 410, 120, 30);
		consultaButton.setFont(buttonFont);
		consultaButton.setBackground(new Color(0,191,255));
		consultaButton.addActionListener(this);
		
		
		//Painel
		cadastroPanel.setBounds(30, 100, 890, 470);
		cadastroPanel.setBackground(new Color(200, 200, 200));
		
		cadastroPanel.add(canalLabel);
		cadastroPanel.add(classificacaoIndicativaLabel);
		cadastroPanel.add(dataLabel);
		cadastroPanel.add(descricaoLabel);
		cadastroPanel.add(generoLabel);
		cadastroPanel.add(horarioLabel);
		cadastroPanel.add(tituloLabel);
		
		cadastroPanel.add(dataTextField);
		cadastroPanel.add(descricaoTextArea);
		cadastroPanel.add(horarioTextField);
		cadastroPanel.add(tituloTextField);
		
		
		cadastroPanel.add(canalComboBox);
		cadastroPanel.add(classificacaoComboBox);
		cadastroPanel.add(tipoComboBox);
		
		cadastroPanel.add(apagaButton);
		cadastroPanel.add(consultaButton);
		cadastroPanel.add(limpaButton);
		cadastroPanel.add(salvaButton);
		
		cadastroPanel.setVisible(true);
		cadastroFrame.add(cadastroPanel);
		cadastroFrame.add(tituloFrameLabel);
		cadastroFrame.setVisible(true);
		
	}
	
	//Gets e Sets dos Atributos de Integração
	public String getInput1() {
		return input1;
	}



	public void setInput1(String input1) {
		this.input1 = input1;
	}



	public String getInput2() {
		return input2;
	}



	public void setInput2(String input2) {
		this.input2 = input2;
	}
	
	public String getInput3() {
		return input3;
	}
	
	public void setInput3(String input3) {
		this.input3 = input3;
	}
	
	
	//Eventos
	
	/**
	 * O método limparTelaCadastroPrograma redefine os valores dos campos de input, colocando-os com o valor 
	 * padrão
	 * @param evt
	 */
	public void limparTelaCadastroPrograma(java.awt.event.ActionEvent evt) {
		tituloTextField.setText("");
		horarioTextField.setText("0h0min");
		descricaoTextArea.setText("");
		canalComboBox.setSelectedIndex(0);
		classificacaoComboBox.setSelectedIndex(0);
		tipoComboBox.setSelectedIndex(0);
	}
	
	/**
	 * O método apagarPrograma se comunica com a classe controlePrograma, enviando o código associado ao programa
	 * para que assim seja possível excluí-lo
	 * @param evt
	 */
	public void apagarPrograma(java.awt.event.ActionEvent evt) {
		boolean sucesso = false;
		ControleFilme controleFilme = new ControleFilme();
		ControleSeriado controleSeriado = new ControleSeriado();
		ControleTelejornal controleTelejornal = new ControleTelejornal();
		
		if(this.codFilme > 0) {
			try {
				sucesso = controleFilme.apagarFilme(this.codFilme);
				if(sucesso) {
					JOptionPane.showMessageDialog(null,"Filme apagado com sucesso!");
					this.limparTelaCadastroPrograma(evt);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao apagar filme. Por favor, selecione um filme");
				}
			} catch (ExceptionDAO ex) {
				Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if(this.codSeriado > 0) {
			try {
				sucesso = controleSeriado.apagarSeriado(this.codSeriado);
				if(sucesso) {
					JOptionPane.showMessageDialog(null, "Seriado apagado com sucesso");
					this.limparTelaCadastroPrograma(evt);
				}
			}catch(ExceptionDAO ex) {
				Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if(this.codTelejornal > 0) {
			try {
				sucesso = controleTelejornal.apagarTelejornal(this.codTelejornal);
				if(sucesso) {
					JOptionPane.showMessageDialog(null, "Telejornal apagado com sucesso");
					this.limparTelaCadastroPrograma(evt);
				}
			}catch(ExceptionDAO ex) {
				Logger.getLogger(TelaCadastroCanal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	/**
	 * O método preparaFilme redefine os valores dos campos de input para os valores definidos nos seus parâmetros
	 * Obs: codFilme é imprescindível para alteração e exclusão de Filmes
	 * @param codFilme
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param tipo
	 * @param titulo
	 * @param horario
	 */
	public void preparaFilme(Integer codFilme, String canal, String classificacao, String descricao, 
			String tipo,  String titulo, String horario) {
		this.codFilme = codFilme;
		for(int contador = 0; contador < canalComboBox.getItemCount(); contador++) {
			if(canalComboBox.getItemAt(contador).equals(canal))
				canalComboBox.setSelectedIndex(contador);
		}
		for(int contador = 0; contador < classificacaoComboBox.getItemCount(); contador++) {
			if(classificacaoComboBox.getItemAt(contador).equals(classificacao))
				classificacaoComboBox.setSelectedIndex(contador);
		}
		this.descricaoTextArea.setText(descricao);
		for(int contador = 0; contador < tipoComboBox.getItemCount(); contador++) {
			if(tipoComboBox.getItemAt(contador).equals(tipo))
				tipoComboBox.setSelectedIndex(contador);
		}
		this.tituloTextField.setText(titulo);
		this.horarioTextField.setText(horario);
	}
	
	/**
	 * O método preparaSeriado redefine os valores dos campos de input para os valores definidos nos seus parâmetros
	 * Obs: codSeriado é imprescindível para alteração e exclusão de Seriado
	 * @param codSeriado
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param tipo
	 * @param titulo
	 * @param horario
	 */
	public void preparaSeriado(Integer codSeriado, String canal, String classificacao, String descricao, 
			String tipo,  String titulo, String horario) {
		this.codSeriado = codSeriado;
		for(int contador = 0; contador < canalComboBox.getItemCount(); contador++) {
			if(canalComboBox.getItemAt(contador).equals(canal))
				canalComboBox.setSelectedIndex(contador);
		}
		for(int contador = 0; contador < classificacaoComboBox.getItemCount(); contador++) {
			if(classificacaoComboBox.getItemAt(contador).equals(classificacao))
				classificacaoComboBox.setSelectedIndex(contador);
		}
		this.descricaoTextArea.setText(descricao);
		for(int contador = 0; contador < tipoComboBox.getItemCount(); contador++) {
			if(tipoComboBox.getItemAt(contador).equals(tipo))
				tipoComboBox.setSelectedIndex(contador);
		}
		this.tituloTextField.setText(titulo);
		this.horarioTextField.setText(horario);
	}
	
	/**
	 * O método preparaTelejornal redefine os valores dos campos de input para os valores definidos nos seus parâmetros
	 * Obs: codTelejornal é imprescindível para alteração e exclusão de Telejornal
	 * @param codTelejornal
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param tipo
	 * @param titulo
	 * @param horario
	 */
	public void preparaTelejornal(Integer codTelejornal, String canal, String classificacao, String descricao, 
			String tipo,  String titulo, String horario) {
		
		this.codTelejornal = codTelejornal;
		for(int contador = 0; contador < canalComboBox.getItemCount(); contador++) {
			if(canalComboBox.getItemAt(contador).equals(canal))
				canalComboBox.setSelectedIndex(contador);
		}
		for(int contador = 0; contador < classificacaoComboBox.getItemCount(); contador++) {
			if(classificacaoComboBox.getItemAt(contador).equals(classificacao))
				classificacaoComboBox.setSelectedIndex(contador);
		}
		this.descricaoTextArea.setText(descricao);
		for(int contador = 0; contador < tipoComboBox.getItemCount(); contador++) {
			if(tipoComboBox.getItemAt(contador).equals(tipo))
				tipoComboBox.setSelectedIndex(contador);
		}
		this.tituloTextField.setText(titulo);
		this.horarioTextField.setText(horario);
	}
	
	/**
	 * O método salvarPrograma se comunica com a classe ControlePrograma e envia os dados de cada tipo 
	 * de programa para que possam ser alterados ou cadastrados
	 * @param evt
	 */
	public void salvarPrograma(java.awt.event.ActionEvent evt) {
		String classificacao = classificacaoComboBox.getSelectedItem().toString();
		String data = dataTextField.getText();
		String descricao = descricaoTextArea.getText();
		String horario = horarioTextField.getText();
		String tipo = tipoComboBox.getSelectedItem().toString();
		String titulo = tituloTextField.getText();
		boolean sucesso = false;
		
		if(input1 != null && input2 != null && input3 != null) {
			try {
				switch(tipo) {
				case "Filme":
					String canalSelecionadoF = canalComboBox.getSelectedItem().toString();
					ControleFilme controleFilme = new ControleFilme();
					
					if(this.codFilme == 0) {
						sucesso = controleFilme.cadastrarFilme(Integer.parseInt(input3), input2, canalSelecionadoF, classificacao,
							data, descricao, horario, titulo);
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "O cadastro do filme "
									+ "foi realizado com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					} else {
						sucesso = controleFilme.alterarFilme(Integer.parseInt(input3), input2, canalSelecionadoF, classificacao, 
								this.codFilme, data, descricao, horario, tipo, titulo);
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "A alteração do filme "
									+ "foi realizada com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					}
					break;
					
				case "Seriado":
					String canalSelecionadoS = canalComboBox.getSelectedItem().toString();
					ControleSeriado controleSeriado = new ControleSeriado();
	
					if(this.codSeriado == 0) {
						sucesso = controleSeriado.cadastrarSeriado(canalSelecionadoS, classificacao, 
								data, descricao, horario, Integer.parseInt(input1), Integer.parseInt(input2),titulo);
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "O cadastro do seriado "
									+ "foi realizado com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					} else {
						sucesso = controleSeriado.alterarSeriado(canalSelecionadoS, classificacao, this.codSeriado, data,
								descricao, horario, Integer.parseInt(input1), Integer.parseInt(input2),titulo);
						
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "A alteração do seriado "
									+ "foi realizada com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					}
					break;
					
				case "Telejornal":
					String canalSelecionadoT = canalComboBox.getSelectedItem().toString();
					ControleTelejornal controleTelejornal = new ControleTelejornal();
	
					if(this.codTelejornal == 0) {
						sucesso = controleTelejornal.cadastrarTelejornal(input1, canalSelecionadoT, classificacao, 
								data, descricao, input3, horario, titulo);
						
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "O cadastro do telejornal "
									+ "foi realizado com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					} else {
						
						sucesso = controleTelejornal.alterarTelejornal(input1, canalSelecionadoT, classificacao, 
								this.codTelejornal, data, descricao, input3, horario, titulo);
						if(sucesso == true) {
							JOptionPane.showMessageDialog(null, "A alteração do telejornal "
									+ "foi realizada com sucesso!");
							this.limparTelaCadastroPrograma(evt);
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não "
									+ "foram preenchidos corretamente.");
						}
					}
					break;
				}
				
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Erro" + ex);
			}
		}
		
	}
	/**
	 * O método actionPerfomed define os eventos da tela de cadastro
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		if(src == consultaButton) {
			TelaConsultaPrograma telaConsulta = new TelaConsultaPrograma("Busca po Titulo");
			telaConsulta.mostrarTela();
			this.cadastroFrame.dispose();
			
		} else if(src == salvaButton) {
			telaDetalhe = new TelaDetalhePrograma();
			String genero = tipoComboBox.getSelectedItem().toString();
			switch(genero) {
			
			case "Filme":
				telaDetalhe.mostrarTela(1);
				break;
			case "Seriado":
				telaDetalhe.mostrarTela(2);
				break;
			default:
				telaDetalhe.mostrarTela(3);
				break;
			
			}
		} else if(src == apagaButton) {
			apagarPrograma(e);
		} else if(src == limpaButton) {
			limparTelaCadastroPrograma(e);
		}
		
	} 
}


