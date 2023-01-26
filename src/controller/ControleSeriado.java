package controller;

import model.Seriado;

public class ControleSeriado {
	public boolean cadastrarSeriado(String classificacao, String descricao, int duracao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) {
		if( classificacao != null && classificacao.length() > 0 && descricao != null &&
				descricao.length() > 0 && duracao > 0 && horario != null && horario.length() > 0 &&
				qtdEpisodios > 0 && qtdTemporadas > 0 && titulo != null && titulo.length() > 0) 
		{
			Seriado novoSeriado = new Seriado(classificacao, descricao,
					duracao, horario, qtdEpisodios, qtdTemporadas, titulo);
			novoSeriado.cadastrarSeriado(novoSeriado);
			return true;
		} 
		return false;
	}
}
