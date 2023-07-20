package Model;

public class Usuario {

	private static String cpf;
	private static String nome;

	public Usuario(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	};

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
