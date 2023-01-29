package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Canal;

/**
 * A classe CanalDAO realiza a conexão entre a Model de Canal e o Banco de Dados, fazendo com que essas camadas 
 * possam transferir os dados de uma para outra
 * @author Caio Alves Braga
 *
 */
public class CanalDAO {
	
	/**
	 * O método cadastrarCanal utiliza a conexão com o Banco de dados e passa a Query(Linguagem SQL) solicitando a 
	 * criação de um novo Canal
	 * @param canal
	 * @throws ExceptionDAO
	 */
	public void cadastrarCanal(Canal canal) throws ExceptionDAO{
		
		String sql = "insert into canal (emissora, número, tipo) value (?, ?, ?)";
		PreparedStatement  pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, canal.getEmissora());
			pStatement.setInt(2, canal.getNumero());
			pStatement.setString(3, canal.getTipo());
			pStatement.execute();
		} catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar canal: " + e);
		}finally {
			try {
				if(pStatement != null) {pStatement.close();}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o Statement: "+ e);
			} try {
				if(connection != null) {connection.close();}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar conexão: " + e);
			}
		}
	}
	
	/**
	 * O método listarCanal solicita as informações desejadas ao Banco de Dados, ordenando os elementos solicitados
	 * por emissora
	 * @param nome
	 * @return
	 * @throws ExceptionDAO
	 */
	public ArrayList<Canal> listarCanal(String nome) throws ExceptionDAO{
		String sql = "select * from canal where emissora like '%" + nome + "%' order by emissora";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Canal> canais = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			
			if(rs != null) {
				canais = new ArrayList<Canal>();
				while(rs.next()) {
					Canal canal = new Canal();
					canal.setCodCanal(rs.getInt("CodCanal"));
					canal.setEmissora(rs.getString("Emissora"));
					canal.setNumero(rs.getInt("Número"));
					canal.setTipo(rs.getString("Tipo"));
					canais.add(canal);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar canal: " + e);
		} finally {
			
			try {
				if(pStatement != null) {pStatement.close();}
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement");
			}
		
			try {
				if(connection != null) {connection.close();}
				
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		
		}
		return canais;
	}
	
	/**
	 * O método alteraCanal recebe os dados da model e dá o comando para que o banco de dados altere os atributos
	 * de um Canal
	 * @param canal
	 * @throws ExceptionDAO
	 */
	public void alteraCanal(Canal canal) throws ExceptionDAO{
		String sql = "Update Canal set emissora = ?, número = ?, tipo = ? where codCanal = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, canal.getEmissora());
			pStatement.setInt(2, canal.getNumero());
			pStatement.setString(3, canal.getTipo());
			pStatement.setInt(4, canal.getCodCanal());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao alterar canal: " + e);
		} finally {
			
			try {
				if(pStatement != null) {pStatement.close();}
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement");
			}
		
			try {
				if(connection != null) {connection.close();}
				
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
	}
	
	/**
	 * O método apagarCanal utiliza apenas o código associado a determinado Canal, e dá o comando ao banco de dados
	 * para que através desse código o Canal seja apagado
	 * @param canal
	 * @throws ExceptionDAO
	 */
	public void apagarCanal(Canal canal) throws ExceptionDAO{
		String sql = "Delete from Canal where codCanal = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, canal.getCodCanal());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar canal: " + e);
		} finally {
			
			try {
				if(pStatement != null) {pStatement.close();}
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement");
			}
		
			try {
				if(connection != null) {connection.close();}
				
			} catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
			}
		}
	}
}
