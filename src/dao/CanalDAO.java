package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Canal;

public class CanalDAO {
	
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
