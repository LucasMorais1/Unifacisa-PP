package br.unifacisa.banco.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Agencia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="codagencia")
	private Long codAgencia;
	
	@Column(name="nomeagencia")
	private String nomeAgencia;

}
