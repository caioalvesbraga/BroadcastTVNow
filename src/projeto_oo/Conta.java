package projeto_oo;

public class Conta extends Dados {
	private Canal canalFavorito;
	private Programa programaFavorito;
	private int userId;

	public Conta(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	

	public String getConta() {
		return toString();
	}

	public Canal getCanalFavorito() {
		return canalFavorito;
	}

	public void setCanalFavorito(int nEmissora, String nome, String assunto) {
		this.canalFavorito = new Canal(nEmissora, nome, assunto);
	}

	public Programa getProgramaFavorito() {
		return programaFavorito;
	}

	public void setProgramaFavorito(String classificacaoIndicativa, String duracao, String genero, String horario,
			String sinopse, String titulo) {
		this.programaFavorito = new Programa(classificacaoIndicativa, duracao, genero, horario, sinopse, titulo);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + "Email: " + email + "\n" + "Senha:" + senha;
	}

}
