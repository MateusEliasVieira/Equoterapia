package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	@Query("SELECT u FROM UsuarioModel u WHERE u.usuario = :usuario AND u.senha = :senha")
	public UsuarioModel buscarUsuarioSenha(@Param("usuario") String usuario, @Param("senha") String senha);

}
