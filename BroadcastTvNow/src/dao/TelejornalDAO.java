package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Telejornal;

/**
 * A classe TelejornalDAO realiza a conexão entre a Model de Telejornal e o Banco de Dados, fazendo com que 
 * essas camadas possam transferir os dados de uma para outra
 * @author Caio Alves Braga
 *
 */
public class TelejornalDAO {
	
	/**
	 * O método cadastrarTelejornal utiliza a conexão com o Banco de dados e passa a Query(Linguagem SQL) solicitando a 
	 * criação de um novo Telejornal
	 * @param telejornal
	 * @throws ExceptionDAO
	 */
	public void cadastrarTelejornal(Telejornal telejornal) throws ExceptionDAO{
		
		String sql = "insert into telejornal (apresentadores, canal, classificação, dataPrograma, descrição, horário, gênero, tipo, título) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement  pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, telejornal.getApresentadores());
			pStatement.setString(2, telejornal.getCanal());
			pStatement.setString(3, telejornal.getClassificacao());
			pStatement.setString(4, telejornal.getDataPrograma());
			pStatement.setString(5, telejornal.getDescricao());
			pStatement.setString(6, telejornal.getHorario());
			pStatement.setString(7, telejornal.getGenero());
			pStatement.setString(8, telejornal.getTipo());
			pStatement.setString(9, telejornal.getTitulo());
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
	
	/**
	 * O método listarTelejornalPorTitulo solicita as informações desejadas ao Banco de Dados, ordenando os 
	 * elementos solicitados por título
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorTitulo(String nome) throws ExceptionDAO{
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
					telejornal.setDataPrograma(rs.getString("DataPrograma"));
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
	
	/**
	 * O método listarTelejornalPorCanal solicita as informações desejadas ao Banco de Dados, ordenando os 
	 * elementos solicitados por canal
	 * @param nome
	 * @return ArrayList<Telejornal>
	 * @throws ExceptionDAO
	 */
	public ArrayList<Telejornal> listarTelejornalPorCanal(String nome) throws ExceptionDAO{
		String sql = "select * from telejornal where canal like '%" + nome + "%' order by canal";
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
					telejornal.setDataPrograma(rs.getString("DataPrograma"));
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
	
	/**
	 * O método alteraTelejornal recebe os dados da model e dá o comando para que o banco de dados altere os 
	 * atributos de um Telejornal
	 * @param seriado
	 * @throws ExceptionDAO
	 */
	public void alterarTelejornal(Telejornal telejornal) throws ExceptionDAO{
		String sql = "Update Telejornal set apresentadores = ?, canal = ?, classificação = ?, dataPrograma = ?, descrição = ?, gênero = ?, horário = ?, tipo = ?, título = ? where codTelejornal = ?";
		PreparedStatement pStatement = null;
		Connection connection = null;
		
		try {
			connection = new ConnectionTV().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, telejornal.getApresentadores());
			pStatement.setString(2, telejornal.getCanal());
			pStatement.setString(3, telejornal.getClassificacao());
			pStatement.setString(4, telejornal.getDataPrograma());
			pStatement.setString(5, telejornal.getDescricao());
			pStatement.setString(6, telejornal.getGenero());
			pStatement.setString(7, telejornal.getHorario());
			pStatement.setString(8, telejornal.getTipo());
			pStatement.setString(9, telejornal.getTitulo());
			pStatement.setInt(10, telejornal.getCodTelejornal());
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
	
	/**
	 * O método apagarTelejornal utiliza apenas o código associado a determinado Telejornal, e dá o comando ao 
	 * banco de dados para que através desse código o Telejornal seja apagado
	 * @param seriado
	 * @throws ExceptionDAO
	 */
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
