package br.com.ifgoiano.equoterapia.equoterapiaapi.api.model;

import java.util.Date;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.EstadoCivil;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.TipoAcesso;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.Vinculo;

public class UsuarioOutput {

	private Long idUsuario;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private EstadoCivil estadoCivil;
	private String cidade;
	private String logradouro;
	private String bairro;
	private Vinculo vinculo;
	private boolean possuiTreinamentoDeEquoterapia;
	private String detalheDoTreinamento;
	private String email;
	private String celular;
	private String foto;
	private TipoAcesso tipoAcesso;
	private String token;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Vinculo getVinculo() {
		return vinculo;
	}

	public void setVinculo(Vinculo vinculo) {
		this.vinculo = vinculo;
	}

	public boolean isPossuiTreinamentoDeEquoterapia() {
		return possuiTreinamentoDeEquoterapia;
	}

	public void setPossuiTreinamentoDeEquoterapia(boolean possuiTreinamentoDeEquoterapia) {
		this.possuiTreinamentoDeEquoterapia = possuiTreinamentoDeEquoterapia;
	}

	public String getDetalheDoTreinamento() {
		return detalheDoTreinamento;
	}

	public void setDetalheDoTreinamento(String detalheDoTreinamento) {
		this.detalheDoTreinamento = detalheDoTreinamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
