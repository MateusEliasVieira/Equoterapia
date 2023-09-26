package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;

public class RegistroInput {

	private String usuario; // nome que o usuário digitou
	private String senha; // senha que o usuário digitou

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
