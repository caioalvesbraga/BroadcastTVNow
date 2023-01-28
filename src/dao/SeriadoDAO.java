package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Seriado;

public class SeriadoDAO {
public void cadastrarSeriado(Seriado seriado) throws ExceptionDAO{
		
		String sql = "insert into seriado (canal, classificação, descrição, horário, qtdEpisódios, qtdTemporadas, tipo, título) value (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement  pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, seriado.getCanal());
			pStatement.setString(2, seriado.getClassificacao());
			pStatement.setString(3, seriado.getDescricao());
			pStatement.setString(4, seriado.getHorario());
			pStatement.setInt(5, seriado.getQtdEpisodios());
			pStatement.setInt(6, seriado.getQtdTemporadas());
			pStatement.setString(7, seriado.getTipo());
			pStatement.setString(8, seriado.getTitulo());
			pStatement.execute();
			
		} catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar seriado: " + e);
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
	
	public ArrayList<Seriado> listarSeriado(String nome) throws ExceptionDAO{
		String sql = "select * from seriado where título like '%" + nome + "%' order by título";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Seriado> seriados = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			
			if(rs != null) {
				seriados = new ArrayList<Seriado>();
				while(rs.next()) {
					Seriado seriado = new Seriado();
					seriado.setCodSeriado(rs.getInt("CodSeriado"));
					seriado.setCanal(rs.getString("Canal"));
					seriado.setClassificacao(rs.getString("Classificação"));
					seriado.setDescricao(rs.getString("Descrição"));
					seriado.setHorario(rs.getString("Horário"));
					seriado.setTitulo(rs.getString("Título"));
					seriados.add(seriado);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar seriado: " + e);
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
		return seriados;
	}
	
	public void alterarSeriado(Seriado seriado) throws ExceptionDAO{
		String sql = "Update Seriado set canal = ?, classificação = ?, descrição = ?, horário = ?, qtdEpisódios = ?, qtdTemporadas = ?, tipo = ?, título = ? where codSeriado = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, seriado.getCanal());
			pStatement.setString(2, seriado.getClassificacao());
			pStatement.setString(3, seriado.getDescricao());
			pStatement.setString(4, seriado.getHorario());
			pStatement.setInt(5, seriado.getQtdEpisodios());
			pStatement.setInt(6, seriado.getQtdTemporadas());
			pStatement.setString(7, seriado.getTipo());
			pStatement.setString(8, seriado.getTitulo());
			pStatement.setInt(9, seriado.getCodSeriado());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao alterar seriado: " + e);
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
	
	public void apagarSeriado(Seriado seriado) throws ExceptionDAO{
		String sql = "Delete from Seriado where codSeriado = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, seriado.getCodSeriado());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar seriado: " + e);
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
