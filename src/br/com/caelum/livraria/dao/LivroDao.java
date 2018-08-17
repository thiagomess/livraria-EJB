package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<Livro> livroPeloNome(String nome) {
		
		

		 TypedQuery<Livro> query = this.manager.createQuery("select l from Livro l where l.titulo like :pTitulo", Livro.class);
	        query.setParameter("pTitulo", "%" + nome + "%");
			
		
		return query.getResultList();
	}

	public void remove(Livro livro) {
		Livro find = manager.find(Livro.class, livro.getId());
		manager.remove(find);
	
	}


}
