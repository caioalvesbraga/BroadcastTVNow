package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.TelejornalDAO;

/**
 * A classe Telejornal herda os atributos e métodos da classe Programa e realiza a ligação com a Classe Data Access Object
 * para executar as interações com o Banco de Dados
 * @author Caio Alves Braga
 *
 */
public class Telejornal extends Programa{
	private String apresentadores;
	private int codTelejornal;
	private String genero;
	
	/**
	 * O Construtor de Telejornal define os parâmetros para quando a classe for instanciada
	 *  e como esses parâmetros serão utilizados em objeto do tipo Telejornal
	 * @param apresentadores
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param tipoDeJornal
	 * @param titulo
	 */
	public Telejornal(String apresentadores, String canal, String classificacao, String dataPrograma, String descricao,
			String genero, String horario, String titulo) {
		
		super(canal, classificacao, dataPrograma, descricao, horario, "Telejornal",  titulo); 
		this.apresentadores = apresentadores;
		this.genero = genero;
	}
	
	/**
	 * O construtor de Telejornal sem parâmetros é utilizado em situações específicas que não demandam o uso de 
	 * construtores com parâmetro, como as operações de listagem de Seriado
	 */
	public Telejornal() {
		super();
	}

	public String getApresentadores() {
		return apresentadores;
	}
	public void setApresentadores(String apresentadores) {
		this.apresentadores = apresentadores;
	}
	
	public int getCodTelejornal() {
		return codTelejornal;
	}

	public void setCodTelejornal(int codTelejornal) {
		this.codTelejornal = codTelejornal;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * O método cadastrarTelejornal realiza a comunicação com a classe Telejornal Data Access Object para 
	 * realização de operações CREATE 
	 * @param jornal
	 * @throws ExceptionDAO
	 */
	public void cadastrarTelejornal(Telejornal jornal) throws ExceptionDAO {
		new TelejornalDAO().cadastrarTelejornal(jornal);
	}
	
	/**
	 * O método listarTelejornalPorTitulo realiza a comunicação com a classe Telejornal Data Access Object para 
	 * realização de operações READ com consulta sendo feita por título
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorTitulo(String nome) throws ExceptionDAO {
		return new TelejornalDAO().listarTelejornalPorTitulo(nome);
	}
	
	/**
	 * O método listarTelejornalPorCanal realiza a comunicação com a classe Telejornal Data Access Object para 
	 * realização de operações READ com consulta sendo feita por canal
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorCanal(String nome) throws ExceptionDAO {
		return new TelejornalDAO().listarTelejornalPorCanal(nome);
	}
	
	/**
	 * O método alterarTelejornal realiza a comunicação com a classe Telejornal Data Access Object para 
	 * realização de operações UPDATE
	 * @param jornal
	 * @throws ExceptionDAO
	 */
	public void alterarTelejornal(Telejornal telejornal) throws ExceptionDAO {
		new TelejornalDAO().alterarTelejornal(telejornal);
		
	}
	
	/**
	 * O método apagarTelejornal realiza a comunicação com a classe Telejornal Data Access Object para 
	 * realização de operações DELETE
	 * @param jornal
	 * @throws ExceptionDAO
	 */
	public void apagarTelejornal(Telejornal telejornal) throws ExceptionDAO {
		new TelejornalDAO().apagarTelejornal(telejornal);
		
	}

	
}
