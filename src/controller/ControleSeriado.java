package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;
import model.Filme;
import model.Seriado;

public class ControleSeriado {
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
	public ArrayList<Seriado> listarSeriado(String nome) throws ExceptionDAO{
		return new Seriado().listarSeriado(nome);
	}
	
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
