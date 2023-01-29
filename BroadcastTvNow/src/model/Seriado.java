package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.SeriadoDAO;

/**
 * A classe Seriado herda os atributos e métodos da classe Programa e realiza a ligação com a Classe Data Access Object
 * para executar as interações com o Banco de Dados
 * @author Caio Alves Braga
 *
 */
public class Seriado extends Programa{
	private int codSeriado;
	private int qtdEpisodios;
	private int qtdTemporadas;
	
	/**
	 * O Construtor de Seriado define os parâmetros para quando a classe for instanciada
	 *  e como esses parâmetros serão utilizados em objeto do tipo Seriado
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param qtdEpisodios
	 * @param qtdTemporadas
	 * @param titulo
	 */
	public Seriado(String canal, String classificacao, String descricao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Seriado" ,  titulo); 
		this.qtdEpisodios = qtdEpisodios;
		this.qtdTemporadas = qtdTemporadas;
	}
	
	/**
	 * O construtor de Seriado sem parâmetros é utilizado em situações específicas que não demandam o uso de 
	 * construtores com parâmetro, como as operações de listagem de Seriado
	 */
	public Seriado() {
		super();
	}
	
	public int getCodSeriado() {
		return codSeriado;
	}

	public void setCodSeriado(int codSeriado) {
		this.codSeriado = codSeriado;
	}
	
	public int getQtdEpisodios() {
		return qtdEpisodios;
	}
	public void setQtdEpisodios(int qtdEpisodios) {
		this.qtdEpisodios = qtdEpisodios;
	}
	public int getQtdTemporadas() {
		return qtdTemporadas;
	}
	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}
	
	@Override
	public String getTipo() {
		return "Seriado";
	}
	
	/**
	 * O método cadastrarSeriado realiza a comunicação com a classe Seriado Data Access Object para realização de 
	 * operações CREATE
	 * @param seriado
	 * @throws ExceptionDAO
	 */
	public void cadastrarSeriado(Seriado seriado) throws ExceptionDAO {
		new SeriadoDAO().cadastrarSeriado(seriado);
	}
	
	/**
	 * O método listarSeriadoPorTitulo realiza a comunicação com a classe Seriado Data Access Object para realização de 
	 * operações READ com consulta sendo feita por título
	 * @param seriado
	 * @return ArrayList<Seriado>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Seriado> listarSeriadoPorTitulo(String nome) throws ExceptionDAO{
		return new SeriadoDAO().listarSeriadoPorTitulo(nome);
	}
	
	/**
	 * O método listarSeriadoPorCanal realiza a comunicação com a classe Seriado Data Access Object para realização de 
	 * operações READ com consulta sendo feita por canal
	 * @param seriado
	 * @return ArrayList<Seriado>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Seriado> listarSeriadoPorCanal(String nome) throws ExceptionDAO{
		return new SeriadoDAO().listarSeriadoPorCanal(nome);
	}
	
	/**
	 * O método alterarSeriado realiza a comunicação com a classe Seriado Data Access Object para realização de 
	 * operações UPDATE Seriado
	 * @param seriado
	 * @throws ExceptionDAO
	 */
	public void alterarSeriado(Seriado seriado) throws ExceptionDAO{
		new SeriadoDAO().alterarSeriado(seriado);
	}
	
	/**
	 * O método alterarSeriado realiza a comunicação com a classe Seriado Data Access Object para realização de 
	 * operações DELETE Seriado
	 * @param seriado
	 * @throws ExceptionDAO
	 */
	public void apagarSeriado(Seriado seriado) throws ExceptionDAO{
		new SeriadoDAO().apagarSeriado(seriado);
	}
	
	
}
