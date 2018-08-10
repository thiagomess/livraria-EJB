package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless // Criamos o session bean, onde sera mapeado pelo JNDI
public class UsuarioDao {

	@PersistenceContext // Como o EJB Container administrará o JPA, é preciso usar uma anotação
						// especifica do mundo EJB
	private EntityManager manager;

	 public Usuario buscaPeloLogin(String login) {
	 // Realizado a busca no banco com JPQL
	
	 Usuario usuario = null;
	 try {
	
	 TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :pLogin", Usuario.class);
	 query.setParameter("pLogin", login);
	 usuario = query.getSingleResult();
	
	 } catch (NoResultException e) {
	 e.printStackTrace();
	 }
	
	 return usuario;
	
	 }

	// Jeito resumido (Exemplo)
//	public Usuario buscaPeloLogin(String login) {
//		// return this.banco.buscaPeloNome(login);
//
//		Usuario usuario = null;
//
//		try {
//			usuario = (Usuario) this.manager.createQuery("select u from Usuario u where u.login=:pLogin")
//					.setParameter("pLogin", login).getSingleResult();
//		} catch (NoResultException e) {
//			// TODO: handle exception
//		}
//
//		return usuario;
//	}

}
