package br.unifacisa.banco.domain.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.unifacisa.banco.domain.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepositoryImplementation<Agencia, Long>{
	
	
}
