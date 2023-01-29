package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.*;
import dao.ExceptionDAO;

public class TestesUnitarios {
	
	@Test
	void testaCadastroCanal() throws ExceptionDAO {
		String [] dados1 = {"", "0", "" };
		String[] dados2 = {"Rede Globo", "10", "Variedades"};
		ControleCanal controleCanal = new ControleCanal();
		assertFalse(controleCanal.cadastrarCanal(dados1[0], Integer.parseInt(dados1[1]), dados1[2]));
		assertTrue(controleCanal.cadastrarCanal(dados2[0], Integer.parseInt(dados2[1]), dados2[2]));
		
	}
	
	@Test
	
	void testaCadastroPrograma() throws ExceptionDAO {
		String[] dados1 = {"William Bonner e Renata Vasconscellos", "Rede Globo", "Livre", 
				"O telejornal mais tradicional", "Informativo", "20h30min", "Jornal Nacional", };
		ControleTelejornal controleTelejornal = new ControleTelejornal();
		assertFalse(controleTelejornal.cadastrarTelejornal(null, null, null, null, null, null, null));
		assertTrue(controleTelejornal.cadastrarTelejornal(dados1[0], dados1[1], dados1[2], dados1[3], 
				dados1[4], dados1[5],dados1[6]));
		
	}
	
	@Test
	void testaAlteraCanal() throws ExceptionDAO {
		String[] dados1 = {null, "0", null};
		String[] dados2 = {"CNN", "577", "Jornalístico"};
		ControleCanal controleCanal = new ControleCanal();
		assertFalse(controleCanal.alterarCanal(0, dados1[0], Integer.parseInt(dados1[1]), dados1[2]));
		assertTrue(controleCanal.alterarCanal(1, dados2[0], Integer.parseInt(dados2[1]), dados2[2]));
		
	}

}
