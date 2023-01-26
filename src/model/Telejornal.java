package model;

public class Telejornal extends Programa{
	private String apresentadores;
	private String tipoDeJornal;
	
	public Telejornal(String apresentadores, String classificacao, String descricao,
			int duracao, String horario, String tipoDeJornal, String titulo) {
		
		super(classificacao, descricao, duracao, horario, "Telejornal",  titulo); 
		this.apresentadores = apresentadores;
		this.tipoDeJornal = tipoDeJornal;
	}
	
	public String getApresentadores() {
		return apresentadores;
	}
	public void setApresentadores(String apresentadores) {
		this.apresentadores = apresentadores;
	}
	public String getTipoDeJornal() {
		return tipoDeJornal;
	}
	public void setTipoDeJornal(String tipoDeJornal) {
		this.tipoDeJornal = tipoDeJornal;
	}
	
	public void cadastrarTelejornal(Telejornal jornal) {
		
	}
}
