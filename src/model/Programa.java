package model;

public abstract class Programa {
	protected String classificacao;
	protected String descricao;
	protected int duracaoMinutos;
	protected String horario;
	protected String tipoDePrograma;
	protected String titulo;

	public Programa(String classificacao, String descricao, int duracao,
			String horario, String tipoDePrograma, String titulo) {

		this.classificacao = classificacao;
		this.descricao = descricao;
		this.duracaoMinutos = duracao;
		this.tipoDePrograma = tipoDePrograma;
		this.horario = horario;
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMin(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getTipoDePrograma() {
		return tipoDePrograma;
	}

	public void setTipoDePrograma(String tipoDePrograma) {
		this.tipoDePrograma = tipoDePrograma;
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
		return "Titulo: " + titulo + "\n" + "Classificação Indicativa: " + classificacao + "\n" + "Duração: "
				+ duracaoMinutos + "\n" + "Tipo: " + tipoDePrograma + "\n" + "Horario: " + horario+ "\n";
	}



}
