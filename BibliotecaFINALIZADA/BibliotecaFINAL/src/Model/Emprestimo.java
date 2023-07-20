package Model;

public class Emprestimo {
	private String cpf_usuario;
	private String isbn_livro;

	public Emprestimo(String cpf_usuario, String isbn_livro) {
		this.setCpf_usuario(cpf_usuario);
		this.setIbn_livro(isbn_livro);
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}

	public String getIsbn_livro() {
		return isbn_livro;
	}

	public void setIbn_livro(String ibn_livro) {
		this.isbn_livro = ibn_livro;
	}

}
