package br.cesed.atividade1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Banco {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int codBancon;
	
	private String nomeBanco;
	
	private Object[] agencias;
	
}
