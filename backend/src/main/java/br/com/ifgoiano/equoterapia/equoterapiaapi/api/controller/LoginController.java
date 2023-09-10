package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.UsuarioService;
import br.com.ifgoiano.equoterapia.equoterapiaapi.security.TokenUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/entrar")
	public ResponseEntity<String> login(@RequestBody LoginInput loginInput) 
	{
		System.out.println("Usuario: "+loginInput.getUsuario()+" e Senha: "+loginInput.getSenha());
		UsuarioModel usuarioModel = modelMapper.map(loginInput, UsuarioModel.class);
		boolean logado = usuarioService.login(usuarioModel);
		//if(logado) {
			// Existe o usuário com usuario e senha
			UsuarioModel usuario = new UsuarioModel();
			usuario.setUsuario(loginInput.getUsuario());
			
			String token = TokenUtil.obterToken(usuario);
			return new ResponseEntity<String>(token,HttpStatus.ACCEPTED);	
		//}
	
		//return new ResponseEntity<String>("Login inválido!",HttpStatus.FORBIDDEN);	
	}
	
	
}
