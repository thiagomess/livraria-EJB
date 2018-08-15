package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless //Criamos o session bean, onde sera mapeado pelo JNDI
@TransactionManagement(TransactionManagementType.CONTAINER) //Apenas para fim didatico, pois já é o padrao
//@Interceptors({LogInterceptor.class}) //Define a classe interceptadora, ou pode se usar o xml, que fica no WebContent chamado ejb-jar.xml
public class AutorDao {

	@PersistenceContext //Como o EJB Container administrará o JPA, é preciso usar uma anotação especifica do mundo EJB
	private EntityManager manager;
	
	@PostConstruct
	void aposACriacao() {
		System.out.println("Criou o AutorDao");
	}
	
	/*
	 * O padrão do TransactionAtributeType é REQUIRED, quando utilizar ele não é preciso usar esta linha
	 *  o Mandatory container verifica se já existe uma transação rodando, caso contrário, joga uma exceção. 
	 *  Ou seja, quem faz a chamada deve abrir uma transação.
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		
		System.out.println("Salvando o autor " +  autor.getNome());
		
//		try {
//			Thread.sleep(20000); //20 seg
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		manager.persist(autor); //Adicionando na tabela com JPA
		
		
		System.out.println("Salvou o autor " + autor.getNome());
		
		//Chamada ao service externo que gera um erro. Desse jeito acontece um rollback e não é salvo no Banco
//		throw new RuntimeException("");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList(); //Efetuando a busca na tabela com JPA
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId); //Efetua a busca do autor pelo ID
		return autor;
	}
	
}
