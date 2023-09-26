package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;

import com.google.gson.Gson;

public class ReplyMessageOutput {

	private String message;

	public ReplyMessageOutput() {
		
	}
	public ReplyMessageOutput(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String messageToJson() {
		Gson gson = new Gson();
		String json = "";
		if(!this.message.isEmpty()) {
			json = gson.toJson(this.message);
		}
		return json;
	}
}
