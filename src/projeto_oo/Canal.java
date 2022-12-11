package projeto_oo;

public class Canal {
	
	private int numeroEmissora;
	private String emissora;
	private String genero;

	public Canal(int numeroEmissora, String nome, String genero) {
		this.numeroEmissora = numeroEmissora;
		this.emissora = nome;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Canal: " + numeroEmissora + "\n" + "Emissora: " + emissora + "\n" + "Gênero: " + genero;
	}

	public void setNumEmissora(int emissora) {
		this.numeroEmissora = emissora;
	}

	public int getNumEmissora() {
		return numeroEmissora;
	}

	public void setNomeEmissora(String nome) {
		this.emissora = nome;
	}

	public String getNomeEmissora() {
		return emissora;
	}

	public void setTipoEmissora(String tipo) {
		this.genero = tipo;
	}

	public String getTipoEmissora() {
		return genero;
	}

}
