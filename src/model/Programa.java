package model;

public abstract class Programa {
	protected String canal;
	protected String classificacao;
	protected String descricao;
	protected String horario;
	protected String tipo;
	protected String titulo;
	

	public Programa(String canal, String classificacao, String descricao,String horario,
			String tipo, String titulo) {

		this.classificacao = classificacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.horario = horario;
		this.titulo = titulo;
		this.canal = canal;
	}

	public Programa() {
		
	}
	
	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "Titulo: " + titulo + "\n" + "Classificação Indicativa: " + classificacao + "\n" + 
	"Tipo: " + tipo + "\n" + "Horario: " + horario+ "\n";
	}



}
