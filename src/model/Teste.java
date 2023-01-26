package model;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		testaCanal();
	}

	// Variaveis Globais
	static String nome = "Caio";
	static String email = "caio@email.com";
	static String senha = "123caio";

	// Métodos
	static void testaCanal() {
		
		System.out.println("############## Canal ###############");
		Canal cnn = new Canal("CNN", "Jornalismo", 77);
		System.out.println(cnn.toString());
		System.out.println("\n*Após os métodos sets de Canal*\n");
		cnn.setEmissora("Repórter Doidão");
		cnn.setNumero(102);
		cnn.setTipoEmissora("Jornalismo True");
		System.out.println("Get de Nome Emissora: " + cnn.getEmissora()
		+ "\nGet de Numero Emissora: "
				+ cnn.getNumero() + "\nGet de Tipo Emissora: "
		+ cnn.getTipoEmissora() + "\n");
		Filme batman = new Filme(4.5, "2 bilhões", "14 anos", "Super-heroi",
				125, "14h30min", "Batman");
		batman.setClassificacao("12 anos");
		
	}
}