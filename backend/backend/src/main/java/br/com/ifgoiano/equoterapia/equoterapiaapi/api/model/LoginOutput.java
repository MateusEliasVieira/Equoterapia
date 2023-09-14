package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;



import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.TipoAcesso;

public class LoginOutput {

	private Long idUsuario;
	private String token;
	private TipoAcesso tipoAcesso;

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

}
