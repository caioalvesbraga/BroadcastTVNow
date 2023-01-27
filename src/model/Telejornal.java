package model;

public class Telejornal extends Programa{
	private String apresentadores;
	private int codCanal;
	private String tipoDeJornal;
	
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
			 String horario, String tipoDeJornal, String titulo) {
		
		super(canal, classificacao, descricao, horario, "Telejornal",  titulo); 
		this.apresentadores = apresentadores;
		this.tipoDeJornal = tipoDeJornal;
	}
	
	public String getApresentadores() {
		return apresentadores;
	}
	public void setApresentadores(String apresentadores) {
		this.apresentadores = apresentadores;
	}
	
	public int getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(int codCanal) {
		this.codCanal = codCanal;
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
