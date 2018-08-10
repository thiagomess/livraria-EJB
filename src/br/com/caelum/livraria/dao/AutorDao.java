package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless //Criamos o session bean, onde sera mapeado pelo JNDI
public class AutorDao {

	@PersistenceContext //Como o EJB Container administrará o JPA, é preciso usar uma anotação especifica do mundo EJB
	private EntityManager manager;
	
	@PostConstruct
	void aposACriacao() {
		System.out.println("Criou o AutorDao");
	}

	public void salva(Autor autor) {
		
		System.out.println("Salvando o autor " +  autor.getNome());
		
//		try {
//			Thread.sleep(20000); //20 seg
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		manager.persist(autor); //Adicionando na tabela com JPA
		
		System.out.println("Salvou o autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList(); //Efetuando a busca na tabela com JPA
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId); //Efetua a busca do autor pelo ID
		return autor;
	}
	
}
