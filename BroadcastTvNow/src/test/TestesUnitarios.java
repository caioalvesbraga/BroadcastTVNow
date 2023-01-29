package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.*;
import dao.ExceptionDAO;

/**
 * A classe TestesUnitarios realiza os testes da aplicação, verificando se os valores de retorno dos métodos
 * e se esses retornos são de acordo com o esperado. Esses métodos são imprescindíveis para o funcionamento
 * do programa
 * @author Caio Alves Braga
 *
 */
public class TestesUnitarios {
	
	/**
	 * O método testaCadastroCanal verifica se o retorno do cadastro de canal é de acordo com o esperado
	 * @throws ExceptionDAO
	 */
	@Test
	void testaCadastroCanal() throws ExceptionDAO {
		String [] dados1 = {"", "0", "" };
		String[] dados2 = {"Rede Globo", "10", "Variedades"};
		ControleCanal controleCanal = new ControleCanal();
		assertFalse(controleCanal.cadastrarCanal(dados1[0], Integer.parseInt(dados1[1]), dados1[2]));
		assertTrue(controleCanal.cadastrarCanal(dados2[0], Integer.parseInt(dados2[1]), dados2[2]));
		
	}
	
	/**
	 * O método testaCadastroPrograma verifica se o retorno do cadastro de programa é de acordo com o esperado
	 * @throws ExceptionDAO
	 */
	@Test
	void testaCadastroPrograma() throws ExceptionDAO {
		String[] dados1 = {"William Bonner e Renata Vasconscellos", "Rede Globo", "Livre", "30/01/2023", 
				"O telejornal mais tradicional", "Informativo", "20h30min", "Jornal Nacional", };
		ControleTelejornal controleTelejornal = new ControleTelejornal();
		assertFalse(controleTelejornal.cadastrarTelejornal(null, null, null, null, null, null, null, null));
		assertTrue(controleTelejornal.cadastrarTelejornal(dados1[0], dados1[1], dados1[2], dados1[3], 
				dados1[4], dados1[5],dados1[6], dados1[7]));
		
	}
	
	/**
	 * O método testaAlteraCanal verifica se o retorno da alteração de canal é de acordo com o esperado
	 * @throws ExceptionDAO
	 */
	@Test
	void testaAlteraCanal() throws ExceptionDAO {
		String[] dados1 = {null, "0", null};
		String[] dados2 = {"CNN", "577", "Jornalístico"};
		ControleCanal controleCanal = new ControleCanal();
		assertFalse(controleCanal.alterarCanal(0, dados1[0], Integer.parseInt(dados1[1]), dados1[2]));
		assertTrue(controleCanal.alterarCanal(1, dados2[0], Integer.parseInt(dados2[1]), dados2[2]));
		
	}

}
