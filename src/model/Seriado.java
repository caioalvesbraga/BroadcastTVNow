package model;

import java.util.ArrayList;

import dao.ExceptionDAO;
import dao.SeriadoDAO;

public class Seriado extends Programa{
	private int codSeriado;
	private int qtdEpisodios;
	private int qtdTemporadas;
	
	public Seriado(String canal, String classificacao, String descricao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Seriado" ,  titulo); 
		this.qtdEpisodios = qtdEpisodios;
		this.qtdTemporadas = qtdTemporadas;
	}
	
	public Seriado() {
		super();
	}
	
	public int getCodSeriado() {
		return codSeriado;
	}

	public void setCodSeriado(int codSeriado) {
		this.codSeriado = codSeriado;
	}
	
	public int getQtdEpisodios() {
		return qtdEpisodios;
	}
	public void setQtdEpisodios(int qtdEpisodios) {
		this.qtdEpisodios = qtdEpisodios;
	}
	public int getQtdTemporadas() {
		return qtdTemporadas;
	}
	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}
	
	@Override
	public String getTipo() {
		return "Seriado";
	}
	
	public void cadastrarSeriado(Seriado seriado) throws ExceptionDAO {
		new SeriadoDAO().cadastrarSeriado(seriado);
	}
	
	public ArrayList<Seriado> listarSeriado(String nome) throws ExceptionDAO{
		return new SeriadoDAO().listarSeriado(nome);
	}
	
	public void alterarSeriado(Seriado seriado) throws ExceptionDAO{
		new SeriadoDAO().alterarSeriado(seriado);
	}
	
	public void apagarSeriado(Seriado seriado) throws ExceptionDAO{
		new SeriadoDAO().apagarSeriado(seriado);
	}
	
	
}
