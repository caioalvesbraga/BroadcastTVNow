package controller;

import model.Telejornal;

public class ControleTelejornal {
	public boolean cadastrarTelejornal(String apresentadores, String classificacao, String descricao, 
			 String horario, String tipoDeJornal, String titulo) {
		if( apresentadores != null  && apresentadores.length() > 0 && classificacao != null &&
				classificacao.length() > 0 && descricao != null && descricao.length() > 0 &&
				horario != null && horario.length() > 0 && tipoDeJornal != null &&
				tipoDeJornal.length() > 0 && titulo != null && titulo.length() > 0) 
		{
			Telejornal novoJornal = new Telejornal(apresentadores, classificacao, descricao,
					 horario, tipoDeJornal, titulo);
			novoJornal.cadastrarTelejornal(novoJornal);
			return true;
		} 
		return false;
	}
}
