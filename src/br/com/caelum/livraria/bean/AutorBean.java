package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorService;
import br.com.caelum.livraria.modelo.Autor;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject //É passado a administração para o EJB Containeir, por isso nao se instancia mais o DAO. (injeção de dependencia)
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() throws LivrariaException {
		this.service.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.todosAutores();
	}
}
