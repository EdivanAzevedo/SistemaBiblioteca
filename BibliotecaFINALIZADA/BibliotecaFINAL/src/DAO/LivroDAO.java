package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Livro;

public class LivroDAO {
	private static Connection connection;
	private final String INSERT_QUERY = "INSERT INTO livros (isbn, nome, editora, categoria) VALUES (?, ?, ?, ?)";
	private final String SELECT_ONE_QUERY = "SELECT * FROM livros WHERE isbn = ?";
	private final static String SELECT_NOME_QUERY = "SELECT * FROM livros WHERE nome = ?";
	private final static String SELECT_EDITORA_QUERY = "SELECT * FROM livros WHERE editora = ?";
	private final static String SELECT_CATEGORIA_QUERY = "SELECT * FROM livros WHERE categoria = ?";

	public LivroDAO() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Livro> pegarPorCategoria(String categoria) throws Exception {
		try {

			List<Livro> livros = new ArrayList<>();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECT_CATEGORIA_QUERY);
			ps.setString(1, categoria);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				livros.add(new Livro(result.getString("nome"), result.getString("isbn"), result.getString("editora"),
						result.getString("categoria")));
			}
			return livros;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean inserir(Livro livro) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			ps.setString(1, Livro.getIsbn());
			ps.setString(2, Livro.getNome());
			ps.setString(3, Livro.getEditora());
			ps.setString(4, Livro.getCategoria());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Livro> pegarPorEditora(String editora) throws Exception {
		try {

			List<Livro> livros = new ArrayList<>();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECT_EDITORA_QUERY);
			ps.setString(1, editora);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				livros.add(new Livro(result.getString("titulo"), result.getString("isbn"), result.getString("editora"),
						result.getString("categoria")));
			}
			return livros;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Livro> pegarPorNome(String nome) throws Exception {
		try {

			List<Livro> livros = new ArrayList<>();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECT_NOME_QUERY);
			ps.setString(1, nome);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				livros.add(new Livro(result.getString("titulo"), result.getString("isbn"), result.getString("editora"),
						result.getString("categoria")));
			}
			return livros;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Livro pegarPorISBN(String isbn) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ONE_QUERY);
			ps.setString(1, isbn);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				return new Livro(result.getString("nome"), result.getString("isbn"), result.getString("editora"),
						result.getString("categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
