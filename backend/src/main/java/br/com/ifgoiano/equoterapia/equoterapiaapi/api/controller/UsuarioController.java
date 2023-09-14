package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.UsuarioInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.UsuarioOutput;
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
	public ResponseEntity<String> cadastrar(@RequestBody UsuarioInput usuarioInput) 
	{
		System.out.println("Bateu aqui");
		UsuarioModel usuarioModel = modelMapper.map(usuarioInput, UsuarioModel.class);
		usuarioModel = usuarioService.salvar(usuarioModel);
		if(usuarioModel != null) {
			return new ResponseEntity<String>("Usuário cadastrado com sucesso!",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Erro ao cadastrar novo usuário!",HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsuarioOutput>> listar()
	{
		List<UsuarioModel> listUsuarioModel = usuarioService.listarTodosUsuarios();
		List<UsuarioOutput> listUsuarioOutput = new ArrayList<UsuarioOutput>();
		for(UsuarioModel usuarioModel: listUsuarioModel) 
		{
			UsuarioOutput usuarioOutput = modelMapper.map(usuarioModel,UsuarioOutput.class);
			listUsuarioOutput.add(usuarioOutput);
		}
		
		return new ResponseEntity<List<UsuarioOutput>>(listUsuarioOutput,HttpStatus.OK);
	}
}
