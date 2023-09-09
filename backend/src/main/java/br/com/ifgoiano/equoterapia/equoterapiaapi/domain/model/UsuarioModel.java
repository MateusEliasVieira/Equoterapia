package br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model;

import java.io.Serializable;
import java.util.Date;

import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.EstadoCivil;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.TipoAcesso;
import br.com.ifgoiano.equoterapia.equoterapiaapi.domain.model.enums.Vinculo;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionario")
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 6423597220827337139L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private Date dataNascimento;
	@NotNull
	@NotEmpty
	private String cpf;
	@NotNull
	@NotEmpty
	private EstadoCivil estadoCivil;
	@NotNull
	@NotEmpty
	private String cidade;
	@NotNull
	@NotEmpty
	private String logradouro;
	@NotNull
	@NotEmpty
	private String bairro;
	@NotNull
	@NotEmpty
	private Vinculo vinculo;
	@NotNull
	private boolean possuiTreinamentoDeEquoterapia;
	@Nullable
	@Column(columnDefinition = "text")
	private String detalheDoTreinamento;
	@Nullable
	@Column(length = 255)
	private String email;
	@Column(length = 20)
	@NotNull
	@NotEmpty
	private String celular;
	@Column(length = 20)
	@NotNull
	@NotEmpty
	private String usuario;
	@Column(length = 10)
	@NotNull
	@NotEmpty
	private String senha;
	@Column(columnDefinition = "text")
	@Nullable
	private String foto;
	@NotNull
	@NotEmpty
	private TipoAcesso tipoAcesso;

	public Long getIdFuncionario() {
		return idUsuario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idUsuario = idFuncionario;
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

	/*
	 * O campo serialVersionUID em uma classe Java, incluindo entidades JPA (Java
	 * Persistence API), é usado para controlar a serialização e desserialização dos
	 * objetos dessa classe. A serialização é o processo de converter um objeto em
	 * uma sequência de bytes, geralmente para fins de armazenamento ou transmissão,
	 * enquanto a desserialização é o processo de reverter essa sequência de bytes
	 * de volta para um objeto. A classe serialVersionUID é um número de versão
	 * serial que identifica exclusivamente a versão de uma classe serializável.
	 * Quando você serializa um objeto, o serialVersionUID é incluído no fluxo
	 * serializado. Quando você desserializa um objeto, o Java verifica se o
	 * serialVersionUID no fluxo corresponde ao serialVersionUID na classe atual. Se
	 * houver uma correspondência, a desserialização é bem-sucedida; caso contrário,
	 * uma exceção InvalidClassException será lançada, indicando que as versões são
	 * incompatíveis. A principal finalidade do serialVersionUID é garantir que os
	 * objetos serializados e desserializados sejam compatíveis entre diferentes
	 * versões da classe. Isso é importante para evitar problemas de
	 * incompatibilidade ao atualizar seu código, por exemplo, quando você está
	 * armazenando objetos serializados em um banco de dados ou os enviando pela
	 * rede e, posteriormente, deseja desserializá-los em uma versão atualizada do
	 * seu aplicativo.
	 */

}
