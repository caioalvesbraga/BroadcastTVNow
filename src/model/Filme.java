package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.FilmeDAO;

public class Filme extends Programa{
	private int avaliacao;
	private String bilheteria;
	private int codFilme;

	public Filme(int avaliacao, String bilheteria, String canal, String classificacao, 
			String descricao, String horario, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Filme", titulo );
		this.avaliacao = avaliacao;
		this.bilheteria = bilheteria;
	}
	
	public Filme(String canal, String classificacao, String descricao, String horario, String tipo, String titulo) {
		super(canal, classificacao, descricao, horario, tipo, titulo);
	}
	
	public Filme() {
		super();
	}
	
	public int getAvaliacao() {
		return this.avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String getBilheteria() {
		return bilheteria;
	}
	
	public void setBilheteria(String bilheteria) {
		this.bilheteria = bilheteria;
	}
	
	public int getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(int codFilme) {
		this.codFilme = codFilme;
	}
	
	@Override
	public String getTipo() {
		return "Filme";
	}
	
	public void cadastrarFilme(Filme filme) throws ExceptionDAO {
		new FilmeDAO().cadastrarFilme(filme);
	}
	
	public ArrayList <Filme> listarFilme(String nome) throws ExceptionDAO{
		return new FilmeDAO().listarFilme(nome);
	}
	
	public void alteraFilme(Filme filme) throws ExceptionDAO{
		new FilmeDAO().alteraFilme(filme);
	}
}
