package Controller;

import java.util.List;

import DAO.LivroDAO;
import Model.Livro;

public class LivroController {
	private LivroDAO livrodao;

	public Boolean validarISBN(String isbn) {
		String cadeiaVerif = "131313131313";
		isbn = isbn.replace(".", "").replace("-", "");
		int somaProdutos = 0;
		for (int i = 0; i <= isbn.length() - 2; i++)
			somaProdutos += Character.getNumericValue(isbn.charAt(i))
					* Character.getNumericValue(cadeiaVerif.charAt(i));
		if (isbn.length() != 13)
			return false;
		for (int i = 0; i <= 12; i++) {
			if (Character.isLetter(Character.getNumericValue(isbn.charAt(i))))
				return false;
		}
		if ((somaProdutos + Character.getNumericValue(isbn.charAt(12))) % 10 == 0)
			return true;
		else
			return false;
	}

	public String printarLivro(Livro livro) {
		return "ISBN: " + Livro.getNome() + "\nNome: " + Livro.getIsbn() + "\nCategoria: " + Livro.getCategoria()
				+ "\nEditora: " + Livro.getEditora();
	}

	public LivroController() {
		livrodao = new LivroDAO();
	}

	public boolean inserir(Livro livro) throws Exception {
		return livrodao.inserir(livro);
	}

	public Livro pegarPorISBN(String isbn) throws Exception {
		if (validarISBN(isbn)) {
			return livrodao.pegarPorISBN(isbn);
		} else {
			return null;
		}

	}

	public List<Livro> pegarPorNome(String nome) throws Exception {
		return LivroDAO.pegarPorNome(nome);
	}

	public List<Livro> buscaLivroEditora(String editora) throws Exception {
		return LivroDAO.pegarPorEditora(editora);
	}

	public List<Livro> pegarPorCategoria(String categoria) throws Exception {
		return LivroDAO.pegarPorCategoria(categoria);
	}

}
