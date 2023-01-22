package projeto_oo;

public class Canal {
	
	private int numeroEmissora;
	private String nomeEmissora;
	private String genero;

	public Canal(int numeroEmissora, String nome, String genero) {
		this.numeroEmissora = numeroEmissora;
		this.nomeEmissora = nome;
		this.genero = genero;
	}

	public int getNumEmissora() {
		return numeroEmissora;
	}

	public void setNumEmissora(int emissora) {
		this.numeroEmissora = emissora;
	}
	
	public String getNomeEmissora() {
		return nomeEmissora;
	}

	
	public void setNomeEmissora(String nomeEmissora) {
		this.nomeEmissora = nomeEmissora;
	}
	
	public String getTipoEmissora() {
		return genero;
	}

	public void setTipoEmissora(String tipo) {
		this.genero = tipo;
	}
	
	@Override
	public String toString() {
		return "Canal: " + numeroEmissora + "\n" + "Emissora: " + nomeEmissora + "\n" + "Gênero: " + genero;
	}

}
