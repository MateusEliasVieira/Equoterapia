package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	@Query("SELECT u FROM UsuarioModel u WHERE u.usuario = :usuario AND u.senha = :senha")
	public UsuarioModel buscarUsuarioSenha(@Param("usuario") String usuario, @Param("senha") String senha);
	
	@Transactional // garante que a transação seja tratada corretamente. 
	@Modifying // A anotação @Modifying informa ao Spring que essa consulta modificará os dados do banco de dados
	@Query("UPDATE UsuarioModel u SET u.token = :token WHERE u.usuario = :usuario")
	public void atualizarTokenUsuario(@Param("token") String token, @Param("usuario") String usuario);
	
	@Query("SELECT u FROM UsuarioModel u WHERE u.token = :token")
	public UsuarioModel buscarPorToken(@Param("token") String token);

}
