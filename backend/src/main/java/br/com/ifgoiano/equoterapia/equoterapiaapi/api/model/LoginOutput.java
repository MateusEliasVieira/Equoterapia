package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;

import com.google.gson.Gson;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.TipoAcesso;

public class LoginOutput {

	private Long idUsuario;
	private String token;
	private TipoAcesso tipoAcesso;

	public LoginOutput(Long idUsuario, String token, TipoAcesso tipoAcesso) {
		super();
		this.idUsuario = idUsuario;
		this.token = token;
		this.tipoAcesso = tipoAcesso;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String loginOutputToJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

}
