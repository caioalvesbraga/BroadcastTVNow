package controller;
import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;

public class ControleCanal {
	
	public boolean cadastrarCanal(String emissora, int numero, String genero) {
		if(emissora != null && emissora.length() > 0 && 
				genero != null && genero.length() > 0 && numero > 0) {
			
			Canal canal = new Canal(emissora, numero, genero);
			canal.cadastrarCanal(canal);
			return true;
		}
		return false;
	}
	
	public ArrayList<Canal> listarCanais(String nome) throws ExceptionDAO{
		return new Canal().listarCanais(nome);
	}
}
