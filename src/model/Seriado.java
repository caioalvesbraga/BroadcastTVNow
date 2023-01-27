package model;

public class Seriado extends Programa{
	private int codCanal;
	private int qtdEpisodios;
	private int qtdTemporadas;
	
	public Seriado(String canal, String classificacao, String descricao, 
			String horario, int qtdEpisodios, int qtdTemporadas, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Seriado" ,  titulo); 
		this.qtdEpisodios = qtdEpisodios;
		this.qtdTemporadas = qtdTemporadas;
	}
	
	public int getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(int codCanal) {
		this.codCanal = codCanal;
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
	
	public void cadastrarSeriado(Seriado serie) {
		
	}
	
	
}
