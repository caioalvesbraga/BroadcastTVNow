package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Canal;
import model.Filme;

/**
 * A classe FilmeDAO realiza a conexão entre a Model de Filme e o Banco de Dados, fazendo com que essas camadas 
 * possam transferir os dados de uma para outra
 * @author Caio Alves Braga
 *
 */
public class FilmeDAO {
	
	/**
	 * O método cadastrarFilme utiliza a conexão com o Banco de dados e passa a Query(Linguagem SQL) solicitando a 
	 * criação de um novo Filme
	 * @param filme
	 * @throws ExceptionDAO
	 */
	public void cadastrarFilme(Filme filme) throws ExceptionDAO{
		
		String sql = "insert into filme (avaliação, bilheteria, canal, classificação, descrição, horário, tipo, título) value (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement  pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, filme.getAvaliacao());
			pStatement.setString(2, filme.getBilheteria());
			pStatement.setString(3, filme.getCanal());
			pStatement.setString(4, filme.getClassificacao());
			pStatement.setString(5, filme.getDescricao());
			pStatement.setString(6, filme.getHorario());
			pStatement.setString(7, filme.getTipo());
			pStatement.setString(8, filme.getTitulo());
			pStatement.execute();
			
		} catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar filme: " + e);
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
	 * O método listarFilmePorTitulo solicita as informações desejadas ao Banco de Dados, ordenando os 
	 * elementos solicitados por título
	 * @param nome
	 * @return ArrayList<Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Filme> listarFilmePorTitulo(String nome) throws ExceptionDAO{
		String sql = "select * from filme where título like '%" + nome + "%' order by título";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Filme> filmes = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			
			if(rs != null) {
				filmes = new ArrayList<Filme>();
				while(rs.next()) {
					Filme filme = new Filme();
					filme.setCodFilme(rs.getInt("CodFilme"));
					filme.setAvaliacao(rs.getInt("Avaliação"));
					filme.setBilheteria(rs.getString("Bilheteria"));
					filme.setCanal(rs.getString("Canal"));
					filme.setClassificacao(rs.getString("Classificação"));
					filme.setDescricao(rs.getString("Descrição"));
					filme.setHorario(rs.getString("Horário"));
					filme.setTitulo(rs.getString("Título"));
					filmes.add(filme);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar filme: " + e);
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
		return filmes;
	}
	
	/**
	 * O método listarFilmePorCanal solicita as informações desejadas ao Banco de Dados, ordenando os 
	 * elementos solicitados por canal
	 * @param nome
	 * @return ArrayList<Filme>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Filme> listarFilmePorCanal(String nome) throws ExceptionDAO{
		String sql = "select * from filme where canal like '%" + nome + "%' order by canal";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ArrayList<Filme> filmes = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			
			if(rs != null) {
				filmes = new ArrayList<Filme>();
				while(rs.next()) {
					Filme filme = new Filme();
					filme.setCodFilme(rs.getInt("CodFilme"));
					filme.setAvaliacao(rs.getInt("Avaliação"));
					filme.setBilheteria(rs.getString("Bilheteria"));
					filme.setCanal(rs.getString("Canal"));
					filme.setClassificacao(rs.getString("Classificação"));
					filme.setDescricao(rs.getString("Descrição"));
					filme.setHorario(rs.getString("Horário"));
					filme.setTitulo(rs.getString("Título"));
					filmes.add(filme);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar filme: " + e);
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
		return filmes;
	}
	
	/**
	 * O método alteraFilme recebe os dados da model e dá o comando para que o banco de dados altere os atributos
	 * de um Filme
	 * @param filme
	 * @throws ExceptionDAO
	 */
	public void alterarFilme(Filme filme) throws ExceptionDAO{
		String sql = "Update Filme set avaliação = ?, bilheteria = ?, canal = ?, classificação = ?, descrição = ?, horário = ?, tipo = ?, título = ? where codFilme = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, filme.getAvaliacao());
			pStatement.setString(2, filme.getBilheteria());
			pStatement.setString(3, filme.getCanal());
			pStatement.setString(4, filme.getClassificacao());
			pStatement.setString(5, filme.getDescricao());
			pStatement.setString(6, filme.getHorario());
			pStatement.setString(7, filme.getTipo());
			pStatement.setString(8, filme.getTitulo());
			pStatement.setInt(9, filme.getCodFilme());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao alterar filme: " + e);
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
	 * O método apagarFilme utiliza apenas o código associado a determinado Filme, e dá o comando ao banco de dados
	 * para que através desse código o Filme seja apagado
	 * @param canal
	 * @throws ExceptionDAO
	 */
	public void apagarFilme(Filme filme) throws ExceptionDAO{
		String sql = "Delete from Filme where codFilme = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, filme.getCodFilme());
			pStatement.execute();
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao apagar filme: " + e);
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
