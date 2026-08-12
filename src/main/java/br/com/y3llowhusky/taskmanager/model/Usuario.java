package br.com.y3llowhusky.taskmanager.model;

import java.time.LocalDate;

public class Usuario {
	
	// atributos do usuário
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataCriacao;
	private EnumStatus status;
	private EnumTipo tipoUsuario;
	
	// construtor padrão do usuário (vazio)
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String email, String telefone, LocalDate dataNascimento, LocalDate dataCriacao,
			EnumStatus status, EnumTipo tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataCriacao = dataCriacao;
		this.status = status;
		this.tipoUsuario = tipoUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public EnumTipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(EnumTipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
