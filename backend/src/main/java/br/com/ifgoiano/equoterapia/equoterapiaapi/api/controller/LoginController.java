package br.com.ifgoiano.equoterapia.equoterapiaapi.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifgoiano.equoterapia.equoterapiaapi.api.model.LoginInput;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping("/entrar")
	public void logar(@RequestBody LoginInput loginInput) {
		
	}
}
