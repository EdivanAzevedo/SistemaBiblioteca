package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private final String INSERT_QUERY = "INSERT INTO pessoas (cpf, nome) VALUES (?, ?)";
	private final String SELECT_ONE_QUERY = "SELECT * FROM pessoas WHERE cpf = ?";
	private final String SELECT_NOME_QUERY = "SELECT * FROM pessoas WHERE nome = ?";

	public UsuarioDAO() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String printarUsu(Usuario usuario) {
		return "Nome: " + usuario.getNome() + "\nCPF: " + usuario.getCpf();
	}

	public boolean inserir(Usuario usuario) {
			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
				ps.setString(1, usuario.getCpf());
				ps.setString(2, usuario.getNome());
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	public Usuario existePorCpf(String cpf) {
			try {
				PreparedStatement ps = connection.prepareStatement(SELECT_ONE_QUERY);
				ps.setString(1, cpf);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					return new Usuario(result.getString("nome"), result.getString("cpf"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	public Usuario pegarPorCpf(String cpf) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ONE_QUERY);
			ps.setString(1, cpf);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				return new Usuario(result.getString("nome"), result.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario pegarPorNome(String nome) {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_NOME_QUERY);
			ps.setString(1, nome);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				return new Usuario(result.getString("nome"), result.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
