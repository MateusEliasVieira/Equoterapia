package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.repository.UsuarioRepository;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioModel salvar(UsuarioModel usuarioModel) 
	{
		Optional<UsuarioModel> funcionarioOptional;
		if(usuarioModel!=null) 
		{
			return usuarioRepository.save(usuarioModel);
			
		}
		return null;
	}

	@Override
	public List<UsuarioModel> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<UsuarioModel> listarUsuarioPorId(Long idFuncionario) {
		Optional<UsuarioModel> optional = usuarioRepository.findById(idFuncionario);
		return optional;
	}

	@Override
	public UsuarioModel atualizar(UsuarioModel usuarioModel) {
		return usuarioRepository.saveAndFlush(usuarioModel);
	}

	@Override
	public boolean deletarPorId(Long idFuncionario) {
	    Optional<UsuarioModel> funcionarioOptional = listarUsuarioPorId(idFuncionario);   
	    if (funcionarioOptional.isPresent()) {
	        usuarioRepository.deleteById(idFuncionario);
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public UsuarioModel login(UsuarioModel usuarioModel) {
		return usuarioRepository.
				buscarUsuarioSenha(usuarioModel.getUsuario(),usuarioModel.getSenha());
		
	}

	@Override
	public void salvarToken(String token, String usuario) {
		usuarioRepository.atualizarTokenUsuario(token, usuario);
		
	}

	@Override
	public UsuarioModel listarUsuarioPorToken(String token) {
		UsuarioModel usuarioModel = usuarioRepository.buscarPorToken(token);
		return usuarioModel;
	}


}
