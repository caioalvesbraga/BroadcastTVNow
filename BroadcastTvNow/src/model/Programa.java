package model;

/**
 * A Classe abstrata Programa define o modelo geral a ser seguido pelas classes que serão usadas como tipos de 
 * programa (Filme, Seriado, Telejornal).
 * @author Caio Alves Braga
 *
 */
public abstract class Programa {
	protected String canal;
	protected String classificacao;
	protected String dataPrograma;
	protected String descricao;
	protected String horario;
	protected String tipo;
	protected String titulo;
	
	/**
	 * O Construtor de Programa define os parâmetros e como esses serão utilizados em uma classe filha de Programa
	 * @param avaliacao
	 * @param bilheteria
	 * @param canal
	 * @param classificacao
	 * @param descricao
	 * @param horario
	 * @param titulo
	 * @param dataPrograma 
	 */
	public Programa(String canal, String classificacao, String dataPrograma, String descricao, String horario,
			String tipo, String titulo) {

		this.classificacao = classificacao;
		this.dataPrograma = dataPrograma;
		this.descricao = descricao;
		this.tipo = tipo;
		this.horario = horario;
		this.titulo = titulo;
		this.canal = canal;
	}
	
	/**
	 * Utilizado em situações específicas nas classes filhas
	 */
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
	
	public String getDataPrograma() {
		return dataPrograma;
	}

	public void setDataPrograma(String dataPrograma) {
		this.dataPrograma = dataPrograma;
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
	
	/**
	 * Define um modelo de String para retorno do objeto 
	 */
	@Override
	public String toString() {
		return "Titulo: " + titulo + "\n" + "Classificação Indicativa: " + classificacao + "\n" + 
	"Tipo: " + tipo + "\n" + "Horario: " + horario+ "\n";
	}



}
