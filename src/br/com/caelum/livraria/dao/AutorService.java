package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

// o Bean recebe as chamadas da tela e delega para o Service, que por sua vez abre a transação e delega para o DAO que 
//a utiliza na finalização do process
@Stateless
public class AutorService {
	
	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) {
		//Poderia ter mais regras de negocio
		dao.salva(autor);
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}

}
