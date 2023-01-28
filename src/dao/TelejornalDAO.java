package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Telejornal;

public class TelejornalDAO {
	public void cadastrarTelejornal(Telejornal telejornal) throws ExceptionDAO{
		
		String sql = "insert into telejornal (apresentadores, canal, classificação, descrição, horário, gênero, tipo, título) value (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement  pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, telejornal.getApresentadores());
			pStatement.setString(2, telejornal.getCanal());
			pStatement.setString(3, telejornal.getClassificacao());
			pStatement.setString(4, telejornal.getDescricao());
			pStatement.setString(5, telejornal.getHorario());
			pStatement.setString(6, telejornal.getGenero());
			pStatement.setString(7, telejornal.getTipo());
			pStatement.setString(8, telejornal.getTitulo());
			pStatement.execute();
			
		} catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar telejornal: " + e);
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
	
	public ArrayList<Telejornal> listarTelejornal(String nome) throws ExceptionDAO{
		String sql = "select * from telejornal where título like '%" + nome + "%' order by título";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Telejornal> telejornais = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			
			if(rs != null) {
				telejornais = new ArrayList<Telejornal>();
				while(rs.next()) {
					Telejornal telejornal = new Telejornal();
					telejornal.setCodTelejornal(rs.getInt("CodTelejornal"));
					telejornal.setApresentadores(rs.getString("Apresentadores"));
					telejornal.setCanal(rs.getString("Canal"));
					telejornal.setClassificacao(rs.getString("Classificação"));
					telejornal.setDescricao(rs.getString("Descrição"));;
					telejornal.setGenero(rs.getString("Gênero"));
					telejornal.setHorario(rs.getString("Horário"));
					telejornal.setTipo(rs.getString("Tipo"));
					telejornal.setTitulo(rs.getString("Título"));
					telejornais.add(telejornal);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar telejornal: " + e);
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
		return telejornais;
	}
	
	public void alterarTelejornal(Telejornal telejornal) throws ExceptionDAO{
		String sql = "Update Telejornal set apresentadores = ?, canal = ?, classificação = ?, descrição = ?, gênero = ?, horário = ?, tipo = ?, título = ? where codTelejornal = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, telejornal.getApresentadores());
			pStatement.setString(2, telejornal.getCanal());
			pStatement.setString(3, telejornal.getClassificacao());
			pStatement.setString(4, telejornal.getDescricao());
			pStatement.setString(5, telejornal.getGenero());
			pStatement.setString(6, telejornal.getHorario());
			pStatement.setString(7, telejornal.getTipo());
			pStatement.setString(8, telejornal.getTitulo());
			pStatement.setInt(9, telejornal.getCodTelejornal());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao alterar telejornal: " + e);
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
	
	public void apagarTelejornal(Telejornal telejornal) throws ExceptionDAO{
		String sql = "Delete from Telejornal where codTelejornal = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, telejornal.getCodTelejornal());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar telejornal: " + e);
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
