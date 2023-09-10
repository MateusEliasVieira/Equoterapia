package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service;

import java.util.List;
import java.util.Optional;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;

public interface UsuarioService {
	
	public UsuarioModel salvar(UsuarioModel usuarioModel);
	public List<UsuarioModel> listarTodosFuncionarios();
	public Optional<UsuarioModel> listarFuncionarioPorId(Long idFuncionario);
	public UsuarioModel atualizar(UsuarioModel usuarioModel);
	public boolean deletarPorId(Long idFuncionario);
	public boolean login(UsuarioModel usuarioModel);
}
