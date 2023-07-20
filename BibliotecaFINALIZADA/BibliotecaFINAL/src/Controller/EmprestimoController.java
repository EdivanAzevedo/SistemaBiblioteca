package Controller;

import DAO.EmprestimoDAO;
import Model.Emprestimo;


public class EmprestimoController {
	
	private EmprestimoDAO emprestimodao = new EmprestimoDAO();
	
	public boolean inserir(Emprestimo emprestimo) {
		return emprestimodao.inserir(emprestimo);
	}
	
public Emprestimo pegarPorISBN(Emprestimo emprestimo) throws Exception {
	return emprestimodao.pegarPorISBN(emprestimo.getIsbn_livro());
}
	
}
