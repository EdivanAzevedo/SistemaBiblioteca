package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Emprestimo;
import Model.Livro;

public class EmprestimoDAO {
	private Connection connection;
	private final String INSERT = "INSERT INTO emprestimos (cpf_pessoa, isbn_livro) VALUES (?,?)";
	private final String SELECT_ONE_QUERY = "SELECT * FROM emprestimos WHERE isbn = ?";

	public EmprestimoDAO() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean inserir(Emprestimo emprestimo) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT);
			ps.setString(1, emprestimo.getCpf_usuario());
			ps.setString(2, emprestimo.getIsbn_livro());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;
		}

	}
	
	public Emprestimo pegarPorISBN(String isbn) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ONE_QUERY);
			ps.setString(1, isbn);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				return new Emprestimo(result.getString("cpf_pessoa"), result.getString("isbn_livro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
