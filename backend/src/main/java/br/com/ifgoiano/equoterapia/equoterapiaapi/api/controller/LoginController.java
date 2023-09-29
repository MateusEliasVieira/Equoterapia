package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginOutput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.RegistroInput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.ReplyMessageOutput;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.RegistroModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.UsuarioModel;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.RegistroService;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.service.UsuarioService;
import br.com.ifgoiano.equoterapia.equoterapiaapi.security.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RegistroService registroService;

	@PostMapping("/entrar")
	public ResponseEntity<String> login(@RequestBody LoginInput loginInput) 
	{
		UsuarioModel usuarioModel = modelMapper.map(loginInput, UsuarioModel.class);
		UsuarioModel usuarioLogado = usuarioService.login(usuarioModel);
		if(usuarioLogado != null) {
			
			// Existe o usuário com usuario e senha
			UsuarioModel usuario = new UsuarioModel();
			usuario.setUsuario(usuarioLogado.getUsuario());
			
			String token = TokenUtil.obterToken(usuario);
			usuarioService.salvarToken(token, usuarioLogado.getUsuario());	
			LoginOutput loginOutput = new LoginOutput(usuarioLogado.getIdUsuario(),token,usuarioLogado.getTipoAcesso());		
			String json = loginOutput.loginOutputToJson();
						
			return new ResponseEntity<String>(json,HttpStatus.ACCEPTED);	
		}
		String json = new ReplyMessageOutput("Login inválido").messageToJson();
		return new ResponseEntity<String>(json,HttpStatus.OK);	
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public HttpStatus registro(@RequestBody RegistroInput registroInput, HttpServletRequest http) 
	{
		RegistroModel registroModel = modelMapper.map(registroInput, RegistroModel.class);
		registroModel.setSistemaOperacional(http.getHeader("User-Agent")); // sistema operacional do cliente
		registroModel.setDataRegistro(new Date());
		registroModel.setIpUsuario(http.getRemoteAddr()); //ip do cliente 
				
		registroService.salvar(registroModel); // salvamos o registro
	
		return HttpStatus.CREATED;
	}
	
	
}
