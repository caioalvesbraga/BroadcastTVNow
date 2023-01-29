package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;
import model.Telejornal;
import model.Telejornal;

/**
 * A classe ControleTëlejornal é a responsável por inteligar a Model de Telejornal com a View de Programa, 
 * fazendo com que essas camadas troquem dados entre si
 * @author Caio Alves Braga
 *
 */
public class ControleTelejornal {
	
	/**
	 * O método cadastrarTelejornal recebe os parâmetros da View de Programa e os utiliza para passar os dados para a 
	 * Model, possibilitando que haja a criação de um novo Telejornal
	 * @param apresentadores
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param genero
	 * @param horario
	 * @param titulo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean cadastrarTelejornal(String apresentadores, String canal, String classificacao, 
			String dataPrograma, String descricao, String genero, String horario, String titulo) throws ExceptionDAO {
		
		if(apresentadores != null  && apresentadores.length() > 0 && classificacao != null &&
				classificacao.length() > 0 && dataPrograma != null && dataPrograma.length() > 0 &&
				descricao != null && descricao.length() > 0 && horario != null && horario.length() > 0  && 
				titulo != null && titulo.length() > 0) 
		{
			Telejornal telejornal = new Telejornal(apresentadores, canal, classificacao, dataPrograma, descricao, genero,
					 horario, titulo);
			telejornal.cadastrarTelejornal(telejornal);
			return true;
		} 
		return false;
	}
	
	/**
	 * O método listarTelejornalPorTitulo recebe os dados que estão vindo da Model e os transmite para a View, 
	 * tornando viável a listagem de Telejornais ordenados por título
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorTitulo(String nome) throws ExceptionDAO{
		return new Telejornal().listarTelejornalPorTitulo(nome);
	}
	
	/**
	 * O método listarTelejornalPorCanal recebe os dados que estão vindo da Model e os transmite para a View, 
	 * tornando viável a listagem de Telejornais ordenados por canal
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorCanal(String nome) throws ExceptionDAO{
		return new Telejornal().listarTelejornalPorCanal(nome);
	}
	
	/**
	 * O método alterarTelejornal recebe os dados das tabela da View e os transmite para a Model para que assim 
	 * seja possível realizar a edição dos valores de um Telejornal
	 * @param apresentadores
	 * @param canal
	 * @param classificacao
	 * @param codTelejornal
	 * @param descricao
	 * @param genero
	 * @param horario
	 * @param titulo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean alterarTelejornal(String apresentadores, String canal, String classificacao, 
			Integer codTelejornal, String data, String descricao, String genero, String horario, 
			String titulo) throws ExceptionDAO{
		
		if(apresentadores != null && apresentadores.length() > 0 && canal != null && canal.length() > 0 && 
				classificacao != null && classificacao.length() > 0 && descricao != null && 
				data != null && data.length() > 0 && descricao.length() > 0  && genero != null && genero.length() > 0 && horario != null && 
				horario.length() > 0 && titulo != null && titulo.length() > 0) {
			
			Telejornal telejornal = new Telejornal(apresentadores, canal, classificacao, data, descricao, genero, 
					horario, titulo);
			telejornal.setCodTelejornal(codTelejornal);
			telejornal.alterarTelejornal(telejornal);
			return true;
		}
		return false;
	}
	
	/**
	 * O método apagarTelejornal recebe o código associado a um Telejornal que estava salvo e exposto na tabela, e 
	 * utiliza esse valor para que o Telejornal seja apagado
	 * @param codTelejornal
	 * @return
	 * @throws ExceptionDAO
	 */
	public boolean apagarTelejornal(int codTelejornal) throws ExceptionDAO {
		
		if(codTelejornal == 0) {
			return false;
		} else {
			Telejornal telejornal = new Telejornal();
			telejornal.setCodTelejornal(codTelejornal);
			telejornal.apagarTelejornal(telejornal);
			return true;
		}
	}
}
