package br.com.caelum.livraria.webservice;

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
public class LivrariaWS {

	@Inject
	LivroDao dao;

	@WebResult(name = "autores") //Para dar um nome ao elemento que representa o retorno usa-se a anotação
	public List<Livro> getLivrosPeloNome(@WebParam(name = "titulo") String nome) { //fica claro para o container EJB que queremos usar aquele nome na mensagem SOAP.

		System.out.println("LivrariaWS: procurando pelo nome " + nome);
		return dao.livroPeloNome(nome);
	}

}
