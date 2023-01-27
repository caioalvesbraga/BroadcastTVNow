package model;

public class Telejornal extends Programa{
	private String apresentadores;
	private String tipoDeJornal;
	private Canal canal;
	
	public Telejornal(String apresentadores, String classificacao, String descricao,
			 String horario, String tipoDeJornal, String titulo) {
		
		super(classificacao, descricao, horario, "Telejornal",  titulo); 
		this.apresentadores = apresentadores;
		this.tipoDeJornal = tipoDeJornal;
		Canal canal = new Canal();
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
