package Model;

public class Livro {
	private static String isbn;
	private static String nome;
	private static String editora;
	private static String categoria;

	public Livro(String isbn, String nome, String editora, String categoria) throws Exception {
		this.setIsbn(isbn);
		this.setNome(nome);
		this.setEditora(editora);
		this.setCategoria(categoria);
	}

	public static String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		Livro.isbn = isbn;
	}

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Livro.nome = nome;
	}

	public static String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		Livro.editora = editora;
	}

	public static String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		Livro.categoria = categoria;
	}

}
