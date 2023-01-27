package model;

public class Filme extends Programa{
	private int avaliacao;
	private String bilheteria;
	private Canal canal;
	
	public Filme(int avaliacao, String bilheteria, String classificacao, 
			String descricao, String horario, String titulo) {
		
		super(classificacao, descricao, horario, "Filme", titulo );
		this.avaliacao = avaliacao;
		this.bilheteria = bilheteria;
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
	
	public Canal getCanal() {
		return canal;
	}
	
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	public void cadastrarFilme(Filme novoFilme) {
		
	}
}
