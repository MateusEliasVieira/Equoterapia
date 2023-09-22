package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;

public class ExceptionMessage {

	private String mensagem;

	public ExceptionMessage(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
