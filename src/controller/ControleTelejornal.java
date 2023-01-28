package controller;

import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;
import model.Telejornal;
import model.Telejornal;

public class ControleTelejornal {
	public boolean cadastrarTelejornal(String apresentadores, String canal, String classificacao, 
			String descricao, String genero, String horario, String titulo) throws ExceptionDAO {
		
		if( apresentadores != null  && apresentadores.length() > 0 && classificacao != null &&
				classificacao.length() > 0 && descricao != null && descricao.length() > 0 &&
				horario != null && horario.length() > 0  && titulo != null && titulo.length() > 0) 
		{
			Telejornal telejornal = new Telejornal(apresentadores, canal, classificacao, descricao, genero,
					 horario, titulo);
			telejornal.cadastrarTelejornal(telejornal);
			return true;
		} 
		return false;
	}
	
	public ArrayList<Telejornal> listarTelejornal(String nome) throws ExceptionDAO{
		return new Telejornal().listarTelejornal(nome);
	}
	
	public boolean alterarTelejornal(String apresentadores, String canal, String classificacao, 
			Integer codTelejornal, String descricao, String genero, String horario, String titulo) throws ExceptionDAO{
		
		if(apresentadores != null && apresentadores.length() > 0 && canal != null && canal.length() > 0 && 
				classificacao != null && classificacao.length() > 0 && descricao != null && 
				descricao.length() > 0  && genero != null && genero.length() > 0 && horario != null && 
				horario.length() > 0 && titulo != null && titulo.length() > 0) {
			
			Telejornal telejornal = new Telejornal(apresentadores, canal, classificacao, descricao, genero, 
					horario, titulo);
			telejornal.setCodTelejornal(codTelejornal);
			telejornal.alterarTelejornal(telejornal);
			return true;
		}
		return false;
	}
	
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
