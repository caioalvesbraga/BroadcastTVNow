package controller;
import java.util.ArrayList;

import dao.ExceptionDAO;
import model.Canal;

/**
 * A classe ControleCanal é a responsável por inteligar a Model de Canal com a View, fazendo com que essas camadas
 * troquem dados entre si
 * @author Caio Alves Braga
 *
 */
public class ControleCanal {
	
	/**
	 * O método cadastrarCanal recebe os parâmetros da View de Canal e os utiliza para passar os dados para a Model
	 * para que haja a criação de um novo Canal 
	 * @param emissora
	 * @param numero
	 * @param tipo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
	public boolean cadastrarCanal(String emissora, int numero, String tipo) throws ExceptionDAO {
		if(emissora != null && emissora.length() > 0 && 
				tipo != null && tipo.length() > 0 && numero > 0) {
			
			Canal canal = new Canal(emissora, numero, tipo);
			canal.cadastrarCanal(canal);
			return true;
		}
		return false;
	}
	/**
	 * O método listarCanais recebe os dados que estão vindo da model e os transmite para a view para que a
	 * listagem seja executada
	 * @param nome
	 * @return
	 * @throws ExceptionDAO
	 */
	public ArrayList<Canal> listarCanais(String nome) throws ExceptionDAO{
		return new Canal().listarCanais(nome);
	}
	
	/**
	 * O método alterarCanal recebe os dados das tabela da View e os transmite para a Model para que assim seja 
	 * possível realizar a edição dos valores de um Canal
	 * @param codCanal
	 * @param emissora
	 * @param numero
	 * @param tipo
	 * @return boolean
	 * @throws ExceptionDAO
	 */
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
	
	/**
	 * O método apagarCanal recebe o código associado a um Canal que estava salvo e exposto na tabela, e utiliza 
	 * esse valor para que o Canal seja apagado
	 * @param codCanal
	 * @return
	 * @throws ExceptionDAO
	 */
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
