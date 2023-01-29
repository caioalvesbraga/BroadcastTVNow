package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;
import model.Filme;
import model.Seriado;

/**
 * A classe ControleSeriado é a responsável por inteligar a Model de Seriado com a View de Programa, fazendo com 
 * que essas camadas troquem dados entre si
 * @author Caio Alves Braga
 *
 */
public class ControleSeriado {
	
	/**
	 * O método cadastrarSeriado recebe os parâmetros da View de Programa e os utiliza para passar os dados para a 
	 * Model, possibilitando que haja a criação de um novo Seriado
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param qtdEpisodios
	 * @param qtdTemporadas
	 * @param titulo
	 * @return
	 * @throws ExceptionDAO
	 */
	public boolean cadastrarSeriado(String canal, String classificacao, String descricao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) throws ExceptionDAO {
		if( classificacao != null && classificacao.length() > 0 && descricao != null &&
				descricao.length() > 0 && horario != null && horario.length() > 0 &&
				qtdEpisodios > 0 && qtdTemporadas > 0 && titulo != null && titulo.length() > 0) 
		{
			Seriado seriado = new Seriado(canal, classificacao, descricao,
				 horario, qtdEpisodios, qtdTemporadas, titulo);
			seriado.cadastrarSeriado(seriado);
			return true;
		} 
		return false;
	}
	
	/**
	 * O método listarSeriadoPorTitulo recebe os dados que estão vindo da Model e os transmite para a View, 
	 * tornando viável a listagem de Seriados ordenados por título
	 * @param nome
	 * @return ArrayList<Seriado>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Seriado> listarSeriadoPorTitulo(String nome) throws ExceptionDAO{
		return new Seriado().listarSeriadoPorTitulo(nome);
	}
	
	/**
	 * O método listarSeriadoPorCanal recebe os dados que estão vindo da Model e os transmite para a View, 
	 * tornando viável a listagem de Seriados ordenados por canal
	 * @param nome
	 * @return ArrayList<Seriado>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Seriado> listarSeriadoPorCanal(String nome) throws ExceptionDAO{
		return new Seriado().listarSeriadoPorCanal(nome);
	}
	
	/**
	 * O método alterarSeriado recebe os dados das tabela da View e os transmite para a Model para que assim seja 
	 * possível realizar a edição dos valores de um Seriado
	 * @param canal
	 * @param classificacao
	 * @param codSeriado
	 * @param descricao
	 * @param horario
	 * @param qtdEpisodios
	 * @param qtdTemporadas
	 * @param titulo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean alterarSeriado(String canal, String classificacao, int codSeriado, String descricao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) throws ExceptionDAO{
		if( canal != null && canal.length() > 0 && classificacao != null && classificacao.length() > 0 &&
				descricao != null && descricao.length() > 0  && horario != null && 
				horario.length() > 0 && qtdEpisodios > 0 && qtdTemporadas > 0 && titulo != null && titulo.length() > 0) {
			
			Seriado seriado = new Seriado(canal, classificacao, descricao, horario, qtdEpisodios, qtdTemporadas, titulo);
			seriado.setCodSeriado(codSeriado);
			seriado.alterarSeriado(seriado);
			return true;
		}
		return false;
	}
	
	/**
	 * O método apagarSeriado recebe o código associado a um Seriado que estava salvo e exposto na tabela, e 
	 * utiliza esse valor para que o Seriado seja apagado
	 * @param codSeriado
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean apagarSeriado(int codSeriado) throws ExceptionDAO {
		if(codSeriado == 0) {
			return false;
		} else {
			Seriado seriado = new Seriado();
			seriado.setCodSeriado(codSeriado);
			seriado.apagarSeriado(seriado);
			return true;
		}
	}
}
