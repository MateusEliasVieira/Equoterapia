package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.RegistroModel;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroModel, Long>{

}
