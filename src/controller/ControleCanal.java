package controller;
import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;

public class ControleCanal {
	
	public boolean cadastrarCanal(String emissora, int numero, String tipo) throws ExceptionDAO {
		if(emissora != null && emissora.length() > 0 && 
				tipo != null && tipo.length() > 0 && numero > 0) {
			
			Canal canal = new Canal(emissora, numero, tipo);
			canal.cadastrarCanal(canal);
			return true;
		}
		return false;
	}
	
	public ArrayList<Canal> listarCanais(String nome) throws ExceptionDAO{
		return new Canal().listarCanais(nome);
	}
	
	public boolean alterarCanal(int codCanal, String emissora, int numero, String tipo) throws ExceptionDAO {
		if(emissora != null && emissora.length() > 0 && 
				tipo != null && tipo.length() > 0 && numero > 0) {
			
			Canal canal = new Canal(emissora, numero, tipo);
			canal.setCodCanal(codCanal);
			canal.alterarCanal(canal);
			return true;
		}
		return false;
	} 
	
	public boolean apagarCanal(int codCanal) throws ExceptionDAO {
		if(codCanal == 0) {
			return false;
		} else {
			Canal canal = new Canal();
			canal.setCodCanal(codCanal);
			canal.apagarCanal(canal);
			return true;
		}
	}
}
