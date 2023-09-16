package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service;

import java.util.List;
import java.util.Optional;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;

public interface UsuarioService {
	
	public UsuarioModel salvar(UsuarioModel usuarioModel);
	public List<UsuarioModel> listarTodosUsuarios();
	public Optional<UsuarioModel> listarUsuarioPorId(Long idFuncionario);
	public UsuarioModel listarUsuarioPorToken(String token);
	public UsuarioModel atualizar(UsuarioModel usuarioModel);
	public boolean deletarPorId(Long idFuncionario);
	public UsuarioModel login(UsuarioModel usuarioModel);
	public void salvarToken(String token, String usuario);
}
