package main;

import java.util.Scanner;

import Controller.LivroController;
import Controller.UsuarioController;
import Controller.EmprestimoController;
import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;

public class main {

	public static void main(String[] args) {

		UsuarioController usuariocontroll = new UsuarioController();
		LivroController livrocontroll = new LivroController();
		EmprestimoController emprestimocontroll = new EmprestimoController();

		Scanner scanner = new Scanner(System.in);
		int opcao, opcao1;
		do {
			System.out.println("****************************************************************");
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("1 - Usuários");
			System.out.println("2 - Livros");
			System.out.println("3 - Emprestimos");
			System.out.println("4 - Sair");
			System.out.println("****************************************************************");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("****************************************************************");
				System.out.println("Escolha uma das opções abaixo:");
				System.out.println("1 - Cadastrar um usuário");
				System.out.println("2 - Buscar usuário por CPF");
				System.out.println("3 - Buscar usuário por nome");
				System.out.println("5 - Sair");
				System.out.println("****************************************************************");

				opcao1 = scanner.nextInt();

				while (opcao1 != 5) {
					switch (opcao1) {
					case 1:
						String nome;
						String cpf;
						System.out.println("Informe o nome do novo usuário:");
						nome = scanner.next();
						System.out.println("Informe o CPF do novo usuário:");
						cpf = scanner.next();
						try {
							if (usuariocontroll.validarCPF(cpf)) {
								Usuario u = new Usuario(cpf, nome);
								if (usuariocontroll.inserir(u)) {
									System.out.println("Usuário cadastrado com sucesso!");
								}
							} else {
								System.out.println("CPF inválido");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						String cpfBusca;
						System.out.println("Informe o CPF do usuário a ser buscado:");
						cpfBusca = scanner.next();
						try {
							if (usuariocontroll.selecionarCpf(cpfBusca) != null) {
								Usuario u = usuariocontroll.selecionarCpf(cpfBusca);
								System.out.println("Usuário encontrado.");
								System.out.println(usuariocontroll.printarUsu(u));
							} else {
								System.out.println("Usuário não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 3:
						String nomeBusca;
						System.out.println("Informe o nome do usuário a ser buscado:");
						nomeBusca = scanner.next();
						try {
							if (usuariocontroll.pegarPorNome(nomeBusca) != null) {
								Usuario u = usuariocontroll.pegarPorNome(nomeBusca);
								System.out.println("Usuário encontrado.");
								System.out.println(usuariocontroll.printarUsu(u));
							} else {
								System.out.println("Usuário não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
					System.out.println("****************************************************************");
					System.out.println("\nEscolha uma das opções abaixo:");
					System.out.println("1 - Cadastrar um usuário");
					System.out.println("2 - Buscar usuário por CPF");
					System.out.println("3 - Buscar usuário por nome");
					System.out.println("5 - Sair");
					System.out.println("****************************************************************");
					opcao1 = scanner.nextInt();
				}
				break;

			case 2:
				do {
					System.out.println("****************************************************************");
					System.out.println("Escolha uma das opções abaixo:");
					System.out.println("1 - Cadastrar um livro");
					System.out.println("2 - Buscar livro por ISBN");
					System.out.println("3 - Buscar livro por nome");
					System.out.println("4 - Buscar livro por editora");
					System.out.println("5 - Buscar livro por categoria");
					System.out.println("6 - Sair");
					System.out.println("****************************************************************");

					opcao1 = scanner.nextInt();

					switch (opcao1) {
					case 1:
						String nome;
						String isbn;
						String editora;
						String categoria;
						System.out.println("Informe o nome do novo livro");
						nome = scanner.next();
						scanner.nextLine();
						System.out.println("Informe o ISBN do novo livro");
						isbn = scanner.next();
						scanner.nextLine();
						System.out.println("Informe o nome da editora");
						editora = scanner.next();
						scanner.nextLine();
						System.out.println("Informe a categoria");
						categoria = scanner.next();
						scanner.nextLine();
						try {
							if (livrocontroll.validarISBN(isbn)) {
								Livro l = new Livro(isbn, nome, editora, categoria);
								if (livrocontroll.inserir(l)) {
									System.out.println("Livro cadastrado com sucesso!");
								}
							} else {
								System.out.println("ISBN inválido");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 2:
						String isbn1;
						System.out.println("Informe o ISBN do livro");
						isbn1 = scanner.next();
						try {
							if (livrocontroll.pegarPorISBN(isbn1) != null) {
								Livro l = livrocontroll.pegarPorISBN(isbn1);
								System.out.println("Livro encontrado.");
								System.out.println(livrocontroll.printarLivro(l));
							} else {
								System.out.println("Livro não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 3:
						String nome1;
						System.out.println("Informe a nome do livro");
						nome1 = scanner.next();
						scanner.nextLine();
						try {
							if (livrocontroll.pegarPorNome(nome1) != null) {
								System.out.println("Livro encontrado.");
							} else {
								System.out.println("Livro não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 4:
						String editora1;
						System.out.println("Informe a editora do livro");
						editora1 = scanner.next();
						scanner.nextLine();
						try {
							if (livrocontroll.buscaLivroEditora(editora1) != null) {
								System.out.println("Livro encontrado.");
							} else {
								System.out.println("Livro não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 5:
						String categoria1;
						System.out.println("Informe a editora do livro");
						categoria1 = scanner.next();
						try {
							if (livrocontroll.pegarPorCategoria(categoria1) != null) {
								System.out.println("Livro encontrado.");
							} else {
								System.out.println("Livro não encontrado.");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				} while (opcao1 != 6);

			case 3:
				do {
					System.out.println("****************************************************************");
					System.out.println("Escolha uma das opções abaixo:");
					System.out.println("1 - Realizar um novo emprestimo");
					System.out.println("2 - Buscar por um emprestimo");
					System.out.println("3 - Sair");
					System.out.println("****************************************************************");

					opcao1 = scanner.nextInt();

					switch (opcao1) {
					case 1:
						String isbn1;
						String cpf1;
						System.out.println("Informe o cpf do usuário: ");
						cpf1 = scanner.next();
						System.out.println("Informe o isbn do livro: ");
						isbn1 = scanner.next();
						try {
							if (usuariocontroll.validarCPF(cpf1) && livrocontroll.validarISBN(isbn1)) {
								Emprestimo em = new Emprestimo(cpf1, isbn1);
								if (emprestimocontroll.inserir(em)) {
									System.out.println("Emprestimo realizado");
								}
							} else {
								System.out.println("CPF inválido ou ISBN inválido");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 2:
						int op3;
						System.out.println("****************************************************************");
						System.out.println("Como deseja procurar pelo emprestimo?");
						System.out.println("1 - Por CPF");
						System.out.println("2 - Por ISBN");
						System.out.println("****************************************************************");
						op3 = scanner.nextInt();
						switch (op3) {
						case 1:
							String isbn2;
							System.out.println("Informe o isbn do livro:");
							isbn2 = scanner.next();
							try {
								if (livrocontroll.validarISBN(isbn2)) {
									emprestimocontroll.pegarPorISBN(isbn2);
									if (emprestimocontroll.inserir(em)) {
										System.out.println("Emprestimo realizado");
									}
								} else {
									System.out.println("CPF inválido ou ISBN inválido");
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 2:
							String cpf2;
							System.out.println("Informe o cpf do usuário:");
							cpf2 = scanner.next();
							break;
						default:
							System.out.println("Opção Inválida");
							break;
						}
						break;

					case 3:
						break;
					}
				} while (opcao1 != 3);
			case 4:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 4);
	}
}
