package br.unifacisa.banco.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="numeroconta")
	private long numeroConta;
	
	@Column(name="numeroagencia")
	private long numeroAgencia;	
	
	private String titular;
	
	private double saldo;

}
