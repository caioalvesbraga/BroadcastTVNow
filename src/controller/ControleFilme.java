package controller;

import model.Filme;

public class ControleFilme {
	public boolean cadastrarFilme(int avaliacao, String bilheteria, String classificacao, 
			String descricao, int duracao, String horario, String titulo) 
	{
		if(avaliacao > 0 && bilheteria != null && bilheteria.length() > 0 && 
				classificacao != null && classificacao.length() > 0 && descricao != null &&
				descricao.length() > 0 && duracao > 0 && horario != null && horario.length() > 0 &&
				titulo != null && titulo.length() > 0) {
			
			Filme novoFilme = new Filme(avaliacao,  bilheteria,  classificacao, descricao, duracao, 
					horario, titulo);
			novoFilme.cadastrarFilme(novoFilme);
			return true;
		} 
		return false;
	}
}
