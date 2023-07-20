package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {
	UsuarioDAO usudao = new UsuarioDAO();

	public UsuarioController() {
		usudao = new UsuarioDAO();
	}

	public String printarUsu(Usuario usuario) {
		return usudao.printarUsu(usuario);
	}

	
		public boolean validarCPF(String cpf) throws IllegalArgumentException {
			cpf = cpf.replace(".", "").replace("-", "").trim();
			if (cpf == null || cpf.isEmpty() || cpf.length() != 11) {
				throw new IllegalArgumentException("CPF Inválido");
			}

			int soma = 0;

			for (int i = 0; i < 9; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			}
			int resto = soma % 11;
			if (resto < 2) {
				if (Character.getNumericValue(cpf.charAt(9)) != 0)
					return false;
			} else {
				if (Character.getNumericValue(cpf.charAt(9)) != 11 - resto)
					return false;
			}

			soma = 0;

			for (int i = 0; i < 10; i++) {
				soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			}

			resto = soma % 11;

			if (resto < 2) {
				if (Character.getNumericValue(cpf.charAt(10)) != 0) {
					return false;
				}
			} else {
				if (Character.getNumericValue(cpf.charAt(10)) != 11 - resto) {
					return false;
				}
			}
			return true;
		}
	

	public boolean inserir(Usuario usuario) {
		return usudao.inserir(usuario);
	}

	public Usuario selecionarCpf(String cpf) {
		return usudao.existePorCpf(cpf);
	}

	public Usuario pegarCpf(String cpf) throws Exception {
		return usudao.pegarPorCpf(cpf);
	}

	public Usuario pegarPorNome(String nome) {
		if (usudao.pegarPorNome(nome) == null) {
			return null;
		}
		return usudao.pegarPorNome(nome);

	}
}
