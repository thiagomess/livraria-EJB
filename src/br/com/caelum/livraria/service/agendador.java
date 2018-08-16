package br.com.caelum.livraria.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class agendador {

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	void agendando() {

		System.out.println("Efetuando verificação de agendamento");

	}

}