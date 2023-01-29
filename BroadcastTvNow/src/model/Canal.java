package model;

import java.util.ArrayList;
import java.util.List;

import dao.CanalDAO;
import dao.ExceptionDAO;

/**
 * Classe Canal agrega objetos herdados de programa e faz conexão com a Data Access Object, isto é, faz interações
 * com as classes  que possuem conexão com o Banco de Dados  
 * @author Caio Alves Braga
 *
 */
public class Canal {
	
	private int codCanal;
	private String emissora;
	private int numero;
	private String tipo;
	private List<Filme> filmes;
	private List<Seriado> seriados;
	private List<Telejornal> telejornais;

	/**
	 * O Construtor Canal define como devem ser instanciados os objetos do tipo Canal e como os seus parâmetros
	 * serão salvos nos atributos do Objeto.
	 * @param emissora
	 * @param numero
	 * @param tipo
	 */
	public Canal(String emissora, int numero, String tipo) {
		this.numero = numero;
		this.emissora = emissora;
		this.tipo = tipo;
	}
	
	/**
	 * O Construtor Canal vazio é utilizado para situações específicasque não necessitam de parâmetros, como a 
	 * listagem de Canais cadastrados
	 */
	public Canal() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getEmissora() {
		return emissora;
	}

	
	public void setEmissora(String nomeEmissora) {
		this.emissora = nomeEmissora;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(int codCanal) {
		this.codCanal = codCanal;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public List<Seriado> getSeriados() {
		return seriados;
	}


	public void setSeriados(List<Seriado> seriados) {
		this.seriados = seriados;
	}



	public List<Telejornal> getTelejornais() {
		return telejornais;
	}



	public void setTelejornais(List<Telejornal> telejornais) {
		this.telejornais = telejornais;
	}
	
	/**
	 * O método cadastrarCanal realiza a comunicação com a classe Canal Data Access Object para realização de 
	 * operações CREATE Canal
	 * @param canal
	 * @throws ExceptionDAO 
	 */
	
	public void cadastrarCanal(Canal canal) throws ExceptionDAO {
		new CanalDAO().cadastrarCanal(canal);
		
	}
	
	/**
	 * O método listarCanais realiza a comunicação com a classe Canal Data Access Object para realização de 
	 * operações READ Canal
	 * @param nome
	 * @return ArrayList<Canal>
	 * @throws ExceptionDAO
	 */
	public ArrayList <Canal> listarCanais(String nome) throws ExceptionDAO{
		return new CanalDAO().listarCanal(nome);
	}
	
	/**
	 * O método alterarCanal realiza a comunicação com a classe Data Access Object para realização de 
	 * operações UPDATE Canal
	 * @param canal
	 * @throws ExceptionDAO
	 */
	public void alterarCanal(Canal canal) throws ExceptionDAO{
		new CanalDAO().alteraCanal(canal);
	}
	
	/**
	 * O método apagarCanal realiza a comunicação com a classe Data Access Object para realização de 
	 * operações DELETE Canal
	 * @param canal
	 * @throws ExceptionDAO
	 */
	
	public void apagarCanal(Canal canal) throws ExceptionDAO{
		new CanalDAO().apagarCanal(canal);
	}

	/**
	 * O método toString é sobrescrito para definir o valor de retorno
	 *  do objeto Canal em uma forma de String desejada
	 */
	@Override
	public String toString() {
		return "Canal: " + numero + "\n" + "Emissora: " + emissora + "\n" + "Tipo: " + tipo;
	}

}
