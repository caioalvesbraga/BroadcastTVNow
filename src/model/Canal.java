package model;

import java.util.ArrayList;
import java.util.List;

import dao.CanalDAO;
import dao.ExceptionDAO;

public class Canal {
	
	private String emissora;
	private int numero;
	private String tipo;
	private List<Filme> filmes;
	private List<Seriado> seriados;
	private List<Telejornal> telejornais;

	public Canal(String emissora, int numero, String tipo ) {
		this.numero = numero;
		this.emissora = emissora;
		this.tipo = tipo;
	}

	public Canal() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getEmissora() {
		return emissora;
	}

	
	public void setEmissora(String nomeEmissora) {
		this.emissora = nomeEmissora;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipoEmissora(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public List<Seriado> getSeriados() {
		return seriados;
	}


	public void setSeriados(List<Seriado> seriados) {
		this.seriados = seriados;
	}



	public List<Telejornal> getTelejornais() {
		return telejornais;
	}



	public void setTelejornais(List<Telejornal> telejornais) {
		this.telejornais = telejornais;
	}
	
	
	public void cadastrarCanal(Canal canal) {
		try {
			new CanalDAO().cadastrarCanal(canal);
		} catch (ExceptionDAO e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList <Canal> listarCanais(String nome) throws ExceptionDAO{
		return new CanalDAO().listarCanal(nome);
	}

	
	@Override
	public String toString() {
		return "Canal: " + numero + "\n" + "Emissora: " + emissora + "\n" + "Gênero: " + tipo;
	}

}
