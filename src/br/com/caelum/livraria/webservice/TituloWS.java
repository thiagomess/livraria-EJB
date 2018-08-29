package br.com.caelum.livraria.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService //anotando a classe para o container EJB publicar o serviços usando os padrões SOAP e WSDL
@Stateless
public class TituloWS {
	
	@Inject
	LivroDao dao;

	@WebResult(name = "livro") //Para dar um nome ao elemento que representa o retorno usa-se a anotação
	public List<String> getListaLivro() { 
		List<String> titulo = new ArrayList<>();
		System.out.println("TituloWS: listando todos os nomes dos livros ");
		List<Livro> todosLivros = dao.todosLivros();
		for (Livro livro : todosLivros) {
			 titulo.add(livro.getTitulo());
		}
		return titulo;
	}

}

