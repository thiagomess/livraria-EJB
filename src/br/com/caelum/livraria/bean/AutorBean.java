package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.service.AutorService;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject //É passado a administração para o EJB Containeir, por isso nao se instancia mais o DAO. (injeção de dependencia)
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void remove(Autor autor) {
		
		String mensagem = null;
		Severity tipoErro = null;
		
		try {
			
			this.service.remove(autor);
			
			mensagem = "Autor removido com sucesso";
			tipoErro = FacesMessage.SEVERITY_INFO;
			
		} catch (Exception e) {
			
			mensagem = "Não é possível excluir autor com um livro vinculado";
			tipoErro = FacesMessage.SEVERITY_ERROR;
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipoErro, 
				mensagem, ""));
		
	}
	
	public void cadastra() throws LivrariaException {
		this.service.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.todosAutores();
	}
}
