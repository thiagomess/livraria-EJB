package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless //Criamos o session bean, onde sera mapeado pelo JNDI
public class LivroDao {
	
	@PersistenceContext //Como o EJB Container administrará o JPA, é preciso usar uma anotação especifica do mundo EJB
	private EntityManager manager;

	public void salva(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

}
