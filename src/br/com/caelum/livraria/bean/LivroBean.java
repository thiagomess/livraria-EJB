package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.LivroService;

//Anotação Model é um estereotipo e possui a @Named e outras anotações embutidas. 
@Model //https://docs.oracle.com/javaee/7/api/javax/enterprise/inject/Model.html
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	@Inject //É passado a administração para o EJB Containeir, por isso nao se instancia mais o DAO. (injeção de dependencia)
	private LivroService livroService;
	@Inject //É passado a administração para o EJB Containeir, por isso nao se instancia mais o DAO.(injeção de dependencia)
	private AutorService autorService;

	public void cadastra() {
		
		Autor autor = this.autorService.buscaPelaId(this.autorId);
		this.livro.setAutor(autor);
		
		this.livroService.adiciona(livro);
		
		this.livro = new Livro();
	}
	
	public void remove(Livro livro) {
		
		this.livroService.remove(livro);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Livro removido com sucesso", ""));
		
	}

	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroService.todosLivros();
	}
}
