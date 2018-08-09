package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless //Criamos o session bean, onde sera mapeado pelo JNDI
public class AutorDao {

	@Inject
	private Banco banco;
	
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
		
		banco.save(autor);
		
		System.out.println("Salvou o autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
