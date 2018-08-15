package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//A classe interceptador é util para tratamento de erros, auditoria ou monitoramento
public class LogInterceptador {
	
	@AroundInvoke //deixa claro para o EJB Container que o método realmente intercepta o fluxo
	public Object intercepta(InvocationContext context) throws Exception {
		//Nesse método podemos executar algum código antes e depois de uma chamada concreta de um Session Bean. 
		
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed(); //"prossegue" com o método interceptado. 
		
		String nomeClasse = context.getTarget().getClass().getSimpleName(); //Pega o nome da classe
		String metodo = context.getMethod().getName(); // pega o nome do metodo
		
		System.out.println(nomeClasse + ", " + metodo);
		System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));
		
		
		return o;
	}

}
