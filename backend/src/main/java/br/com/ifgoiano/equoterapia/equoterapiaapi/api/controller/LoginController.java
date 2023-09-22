package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.ExceptionMessage;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginOutput;
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
		//System.out.println("Usuario: "+loginInput.getUsuario()+" e Senha: "+loginInput.getSenha());
		UsuarioModel usuarioModel = modelMapper.map(loginInput, UsuarioModel.class);
		UsuarioModel usuarioLogado = usuarioService.login(usuarioModel);
		if(usuarioLogado != null) {
			// Existe o usuário com usuario e senha
			UsuarioModel usuario = new UsuarioModel();
			usuario.setUsuario(usuarioLogado.getUsuario());
			
			String token = TokenUtil.obterToken(usuario);
			
			usuarioService.salvarToken(token, usuarioLogado.getUsuario());
			
			LoginOutput loginOutput = new LoginOutput();
			loginOutput.setIdUsuario(usuarioLogado.getIdUsuario());
			loginOutput.setToken(token);
			loginOutput.setTipoAcesso(usuarioLogado.getTipoAcesso());
		
			Gson gson = new Gson();
			String json = gson.toJson(loginOutput);
						
			return new ResponseEntity<String>(json,HttpStatus.ACCEPTED);	
		}
		String json = new Gson().toJson(new ExceptionMessage("Login inválido"));
		return new ResponseEntity<String>(json,HttpStatus.FORBIDDEN);	
	}
	
	
}
