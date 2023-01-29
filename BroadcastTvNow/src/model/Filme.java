package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.FilmeDAO;

/**
 * A classe Filme herda os atributos e métodos da classe Programa e realiza a ligação com a Classe Data Access Object
 * para executar as interações com o Banco de Dados
 * @author Caio Alves Braga
 *
 */
public class Filme extends Programa{
	private int avaliacao;
	private String bilheteria;
	private int codFilme;
	private String data;

	

	/**
	  * O Construtor de Filme define os parâmetros para quando a classe for instanciada
	 *  e como esses parâmetros serão utilizados em objeto do tipo Filme
	 * @param avaliacao
	 * @param bilheteria
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param titulo
	 */
	public Filme(int avaliacao, String bilheteria, String canal, String classificacao, String data, 
			String descricao, String horario, String titulo) {
		
		super(canal, classificacao, data, descricao, horario, "Filme", titulo );
		this.avaliacao = avaliacao;
		this.bilheteria = bilheteria;
	}
	
	/**
	 * O construtor de Filme sem parâmetros é utilizado em situações específicas que não demandam o uso de Construtores com
	 *  parâmetro, como as operações de listagem de Filme
	 */
	public Filme() {
		super();
	}
	
	public int getAvaliacao() {
		return this.avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String getBilheteria() {
		return bilheteria;
	}
	
	public void setBilheteria(String bilheteria) {
		this.bilheteria = bilheteria;
	}
	
	public int getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(int codFilme) {
		this.codFilme = codFilme;
	}
	
	@Override
	public String getTipo() {
		return "Filme";
	}
	
	/**
	 * O método cadastrarFilme realiza a comunicação com a classe Filme Data Access Object para realização de 
	 * operações CREATE Filme
	 * @param filme
	 * @throws ExceptionDAO
	 */
	public void cadastrarFilme(Filme filme) throws ExceptionDAO {
		new FilmeDAO().cadastrarFilme(filme);
	}
	
	/**
	 * O método listarFilme realiza a comunicação com a classe Filme Data Access Object para realização de 
	 * operações READ Filme com consulta sendo feita por título
	 * @param nome
	 * @return ArrayList <Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList <Filme> listarFilmePorTitulo(String nome) throws ExceptionDAO{
		return new FilmeDAO().listarFilmePorTitulo(nome);
	}
	
	/**
	 * O método listarFilme realiza a comunicação com a classe Filme Data Access Object para realização de 
	 * operações READ Filme com consulta sendo feita por título
	 * @param nome
	 * @return ArrayList <Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList <Filme> listarFilmePorCanal(String nome) throws ExceptionDAO{
		return new FilmeDAO().listarFilmePorCanal(nome);
	}
	/**
	 * O método alterarFilme realiza a comunicação com a classe Filme Data Access Object para realização de 
	 * operações UPDATE Filme
	 * @param filme
	 * @throws ExceptionDAO
	 */
	public void alterarFilme(Filme filme) throws ExceptionDAO{
		new FilmeDAO().alterarFilme(filme);
	}
	
	/**
	 * O método apagarrFilme realiza a comunicação com a classe Filme Data Access Object para realização de 
	 * operações DELETE
	 * @param filme
	 * @throws ExceptionDAO
	 */
	public void apagarFilme(Filme filme) throws ExceptionDAO{
		new FilmeDAO().apagarFilme(filme);
	}
}
