package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.UsuarioInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController 
{
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/novo")
	public String cadastrar(@RequestBody UsuarioInput usuarioInput) 
	{
		UsuarioModel usuarioModel = modelMapper.map(usuarioInput, UsuarioModel.class);
		usuarioModel = usuarioService.salvar(usuarioModel);
		
		return "Usuario cadastrado";
	}
}
