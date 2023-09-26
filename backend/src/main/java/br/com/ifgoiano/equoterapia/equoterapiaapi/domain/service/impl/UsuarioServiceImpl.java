package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
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
	public UsuarioModel salvar(UsuarioModel usuarioModel) throws Exception, SQLIntegrityConstraintViolationException
	{
		if(usuarioModel!=null) 
		{	
			if(this.usuarioExiste(usuarioModel.getUsuario())) 
			{
				 throw new SQLIntegrityConstraintViolationException("O usuário '"+usuarioModel.getUsuario()+"' já existe!");
			}else {
				return usuarioRepository.save(usuarioModel);				
			}
		}
		throw new IllegalArgumentException("O usuário está nulo!");
	}

	@Override
	public List<UsuarioModel> listarTodosUsuarios() 
	{
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<UsuarioModel> listarUsuarioPorId(Long idFuncionario) 
	{
		Optional<UsuarioModel> optional = usuarioRepository.findById(idFuncionario);
		return optional;
	}

	@Override
	public UsuarioModel atualizar(UsuarioModel usuarioModel) 
	{
		return usuarioRepository.saveAndFlush(usuarioModel);
	}

	@Override
	public boolean deletarPorId(Long idFuncionario) 
	{
	    Optional<UsuarioModel> funcionarioOptional = listarUsuarioPorId(idFuncionario);   
	    if (funcionarioOptional.isPresent()) 
	    {
	        usuarioRepository.deleteById(idFuncionario);
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public UsuarioModel login(UsuarioModel usuarioModel) 
	{
		return usuarioRepository.
				buscarUsuarioSenha(usuarioModel.getUsuario(),usuarioModel.getSenha());
		
	}

	@Override
	public void salvarToken(String token, String usuario) 
	{
		usuarioRepository.atualizarTokenUsuario(token, usuario);
		
	}

	@Override
	public UsuarioModel listarUsuarioPorToken(String token) 
	{
		UsuarioModel usuarioModel = usuarioRepository.buscarPorToken(token);
		return usuarioModel;
	}

	private boolean usuarioExiste(String usuario) 
	{
		UsuarioModel usuarioModel = usuarioRepository.buscarPorNomeDeUsuario(usuario);
		if(usuarioModel != null) 
		{
			return true;
		}
		return false;
	}

}
