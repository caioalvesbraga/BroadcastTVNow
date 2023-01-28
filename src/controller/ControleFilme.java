package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.FilmeDAO;
import model.Canal;
import model.Filme;

public class ControleFilme {
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
	
	public ArrayList<Filme> listarFilme(String nome) throws ExceptionDAO{
		return new Filme().listarFilme(nome);
	}
	
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
