package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@WebService
@Stateless
public class AutorWS {
	
	@Inject
	AutorDao dao;
	
	@WebResult(name="Autores")
	public List<Autor> getListaAutores(){
		return dao.todosAutores();
		
	}
}
