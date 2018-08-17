package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.bean.LivrariaException;
import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

// o Bean recebe as chamadas da tela e delega para o Service, que por sua vez abre a transação e delega para o DAO que 
//a utiliza na finalização do process
@Stateless
public class AutorService {
	
	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) throws LivrariaException {
		//Poderia ter mais regras de negocio
		dao.salva(autor);
		
		//Uma regra de negocio que deu errado
//		throw new LivrariaException(); // Por ser uma excpetion checked, não acontece rollback, os dados sao salvos no BD.
		
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		return dao.buscaPelaId(autorId);
	}

	public void remove(Autor autor) {

			dao.remove(autor);
			

	}

	
	
	
	
	
}
