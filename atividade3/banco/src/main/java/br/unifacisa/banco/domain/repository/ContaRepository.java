package br.unifacisa.banco.domain.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.unifacisa.banco.domain.model.Conta;

@Repository
public interface ContaRepository extends JpaRepositoryImplementation<Conta, Long>{

}
