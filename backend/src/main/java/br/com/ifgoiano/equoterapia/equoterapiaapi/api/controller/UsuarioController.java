package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
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

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.ReplyMessageOutput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.TokenInput;
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
		ReplyMessageOutput replyMessageOutput = new ReplyMessageOutput();
		UsuarioModel usuarioModel = modelMapper.map(usuarioInput, UsuarioModel.class);
		try {
			usuarioModel = usuarioService.salvar(usuarioModel);
			if(usuarioModel != null) 
			{
				replyMessageOutput.setMessage("Usuário cadastrado com sucesso!");
				String json = replyMessageOutput.messageToJson();
				return new ResponseEntity<String>(json,HttpStatus.CREATED);
			}
		} 
		catch (SQLIntegrityConstraintViolationException e) 
		{
			e.printStackTrace();
			replyMessageOutput.setMessage(e.getMessage());
			String json = replyMessageOutput.messageToJson();
			return new ResponseEntity<String>(json,HttpStatus.CONFLICT);
		}
		catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
			replyMessageOutput.setMessage(e.getMessage());
			String json = replyMessageOutput.messageToJson();
			return new ResponseEntity<String>(json,HttpStatus.NO_CONTENT);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			replyMessageOutput.setMessage(e.getMessage());
			String json = replyMessageOutput.messageToJson();
			return new ResponseEntity<String>(json,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String json = replyMessageOutput.messageToJson();
		return new ResponseEntity<String>(json,HttpStatus.FORBIDDEN);
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
	
	@PostMapping("/listar/token")
	public ResponseEntity<UsuarioOutput> listarPorToken(@RequestBody TokenInput tokenInput){
		System.out.println("chegou");
		UsuarioModel usuarioModel = usuarioService.listarUsuarioPorToken(tokenInput.getToken());
		UsuarioOutput usuarioOutput = modelMapper.map(usuarioModel, UsuarioOutput.class);
		return new ResponseEntity<UsuarioOutput>(usuarioOutput, HttpStatus.OK);					
	}
}
