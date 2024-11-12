package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario emerson = new Usuario("Emerson", "emerson@gmail.com");
		Usuario carlos = new Usuario("carlos", "carlos@gmail.com");
		Usuario maria = new Usuario("maria", "maria@gmail.com");

		// insert
		dao.insert(emerson);
		dao.insert(carlos);
		dao.insert(maria);

		List<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.selectAll();

		for (Usuario usuario : lista) {
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Email: " + usuario.getEmail());
		}
	}

}
