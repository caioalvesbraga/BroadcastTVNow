package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.TelejornalDAO;

public class Telejornal extends Programa{
	private String apresentadores;
	private int codTelejornal;
	private String genero;
	
	/**
	 * @param apresentadores
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param tipoDeJornal
	 * @param titulo
	 */
	public Telejornal(String apresentadores, String canal, String classificacao, String descricao,
			String genero, String horario, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Telejornal",  titulo); 
		this.apresentadores = apresentadores;
		this.genero = genero;
	}
	
	public Telejornal() {
		super();
	}

	public String getApresentadores() {
		return apresentadores;
	}
	public void setApresentadores(String apresentadores) {
		this.apresentadores = apresentadores;
	}
	
	public int getCodTelejornal() {
		return codTelejornal;
	}

	public void setCodTelejornal(int codTelejornal) {
		this.codTelejornal = codTelejornal;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void cadastrarTelejornal(Telejornal jornal) throws ExceptionDAO {
		new TelejornalDAO().cadastrarTelejornal(jornal);
	}
	
	public ArrayList<Telejornal> listarTelejornal(String nome) throws ExceptionDAO {
		return new TelejornalDAO().listarTelejornal(nome);
	}

	public void alterarTelejornal(Telejornal telejornal) throws ExceptionDAO {
		new TelejornalDAO().alterarTelejornal(telejornal);
		
	}

	public void apagarTelejornal(Telejornal telejornal) throws ExceptionDAO {
		new TelejornalDAO().apagarTelejornal(telejornal);
		
	}

	
}
