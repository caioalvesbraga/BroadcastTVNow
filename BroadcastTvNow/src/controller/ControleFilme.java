package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.FilmeDAO;
import model.Canal;
import model.Filme;

/**
 * A classe ControleFilme é a responsável por inteligar a Model de Filme com a View de Programa, fazendo com que 
 * essas camadas troquem dados entre si
 * @author Caio Alves Braga
 *
 */
public class ControleFilme {
	
	/**
	 * O método cadastrarFilme recebe os parâmetros da View de Programa e os utiliza para passar os dados para a Model,
	 * possibilitando que haja a criação de um novo Filme 
	 * @param avaliacao
	 * @param bilheteria
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param titulo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean cadastrarFilme(int avaliacao, String bilheteria, String canal, String classificacao, 
			String descricao, String horario, String titulo) throws ExceptionDAO 
	{
		if(avaliacao > 0 && bilheteria != null && bilheteria.length() > 0 &&  canal != null && 
				canal.length() > 0 && classificacao != null && classificacao.length() > 0 &&
				descricao != null && descricao.length() > 0  && horario != null && 
				horario.length() > 0 && titulo != null && titulo.length() > 0) {
			
			Filme novoFilme = new Filme(avaliacao,  bilheteria, canal, classificacao, descricao, 
					horario, titulo);
			novoFilme.cadastrarFilme(novoFilme);
			return true;
		} 
		return false;
	}
	
	/**
	 * O método listarFilmePorTitulo recebe os dados que estão vindo da Model e os transmite para a View, tornando
	 * viável a listagem de Filmes ordenados por título
	 * @param nome
	 * @return ArrayList <Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Filme> listarFilmePorTitulo(String nome) throws ExceptionDAO{
		return new Filme().listarFilmePorTitulo(nome);
	}
	
	/**
	 * O método listarFilmePorCanal recebe os dados que estão vindo da Model e os transmite para a View, tornando
	 * viável a listagem de Filmes ordenados por canal
	 * @param nome
	 * @return ArrayList <Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Filme> listarFilmePorCanal(String nome) throws ExceptionDAO{
		return new Filme().listarFilmePorCanal(nome);
	}
	
	/**
	 * O método alterarFilme recebe os dados das tabela da View e os transmite para a Model para que assim seja 
	 * possível realizar a edição dos valores de um Filme
	 * @param avaliacao
	 * @param bilheteria
	 * @param canal
	 * @param classificacao
	 * @param codCanal
	 * @param descricao
	 * @param horario
	 * @param tipo
	 * @param titulo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean alterarFilme(int avaliacao, String bilheteria, String canal, String classificacao, 
			Integer codCanal, String descricao, String horario, String tipo, String titulo) throws ExceptionDAO{
		if(avaliacao > 0 && bilheteria != null && bilheteria.length() > 0 &&  canal != null && 
				canal.length() > 0 && classificacao != null && classificacao.length() > 0 &&
				descricao != null && descricao.length() > 0  && horario != null && 
				horario.length() > 0 && titulo != null && titulo.length() > 0) {
			
			Filme filme = new Filme(avaliacao, bilheteria, canal, classificacao, descricao, horario, titulo);
			filme.setCodFilme(codCanal);
			filme.alterarFilme(filme);
			return true;
		}
		return false;
	}
	
	/**
	 * O método apagarFilme recebe o código associado a um Filme que estava salvo e exposto na tabela, e utiliza 
	 * esse valor para que o Filme seja apagado
	 * @param codFilme
	 * @return
	 * @throws ExceptionDAO
	 */
	public boolean apagarFilme(Integer codFilme) throws ExceptionDAO {
		if(codFilme == 0) {
			return false;
		} else {
			Filme filme = new Filme();
			filme.setCodFilme(codFilme);
			filme.apagarFilme(filme);
			return true;
		}
	} 
}
