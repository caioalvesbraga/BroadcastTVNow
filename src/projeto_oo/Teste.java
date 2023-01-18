package projeto_oo;

public class Teste {

	public static void main(String[] args) {
		testaCanal();
		testaContaEDados();
		testaFavoritos();
		testaPrograma();
	}

	// Variaveis Globais
	static String nome = "Caio";
	static String email = "caio@email.com";
	static String senha = "123caio";

	// Métodos
	static void testaCanal() {

		System.out.println("############## Canal ###############");
		Canal cnn = new Canal(77, "CNN", "Jornalismo");
		System.out.println(cnn.toString());
		System.out.println("\n*Após os métodos sets de Canal*\n");
		cnn.setNomeEmissora("Repórter Doidão");
		cnn.setNumEmissora(102);
		cnn.setTipoEmissora("Jornalismo True");
		System.out.println("Get de Nome Emissora: " + cnn.getNomeEmissora()
		+ "\nGet de Numero Emissora: "
				+ cnn.getNumEmissora() + "\nGet de Tipo Emissora: "
		+ cnn.getTipoEmissora() + "\n");
	}

	static void testaContaEDados() {

		Conta novaConta = new Conta(nome, email, senha);

		System.out.println("############## Conta ###############");
		System.out.println(novaConta.getConta());
		System.out.println("\n*Após os métodos sets da classe Dados*\n");
		novaConta.setNome("Fernando");
		novaConta.setEmail("fernandocas@gmail.com");
		novaConta.setSenha("Fernando123.");

		System.out.println(novaConta.getConta());
		System.out.println("\n");
	}

	static void testaFavoritos() {
		Conta novaConta = new Conta(nome, email, senha);

		System.out.println("############## Canal Favorito ###############");

		novaConta.setCanalFavorito(10, "Globo", "Jornalistico");

		System.out.println(novaConta.getCanalFavorito());

		novaConta.setCanalFavorito(12, "SBT", "Variedades");

		System.out.println("\n");
		System.out.println(novaConta.getCanalFavorito());
		System.out.println("\n");

		System.out.println("############## Programa Favorito ###############");
		novaConta.setProgramaFavorito("12", "2h e 30min", "Herois", "21h",
				"Batman é um super-heroi", "Batman");
		System.out.print(novaConta.getProgramaFavorito());
		System.out.println("\n*Após os métodos sets de Programa Favorito*\n");
		novaConta.setProgramaFavorito("18", "2h e 42min", "Herois", "23h", 
				"Deadpool é um anti-heroi", "Deadpool");
		System.out.println(novaConta.getProgramaFavorito());
	}

	static void testaPrograma() {

		System.out.println("############## Programa ###############");
		Programa caldeirao = new Programa("AL", "1h e 30min", "Auditório", "14h",
				"Caldeirão é um programa de auditório\napresentado por Marcos Mion"
				, "Caldeirao");
		System.out.print(caldeirao.toString());
		System.out.print("\n*Após os métodos sets de Programa*\n");
		caldeirao.setClassificacaoIndicativa("A10");
		caldeirao.setDuracao("45min");
		System.out.println("\nGet de Classificação Indicativa: " + 
		caldeirao.getClassificacaoIndicativa()
				+ "\nGet de Duração: " + caldeirao.getDuracao());
	}
}