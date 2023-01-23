package projeto_oo;

public class Programa {
	private String classificacaoIndicativa;
	private String duracao;
	private String genero;
	private String horario;
	private String titulo;

	public Programa(String classificacaoIndicativa, String duracao, String genero, String horario,
			String titulo) {

		this.classificacaoIndicativa = classificacaoIndicativa;
		this.duracao = duracao;
		this.genero = genero;
		this.horario = horario;
		this.titulo = titulo;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + titulo + "\n" + "Classificação Indicativa: " + classificacaoIndicativa + "\n" + "Duração: "
				+ duracao + "\n" + "Genero: " + genero + "\n" + "Horario: " + horario+ "\n";
	}

}
