package br.com.y3llowhusky.taskmanager.model;

import java.time.LocalDate;

public class Usuario {
	
	// atributos do usuário
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataCadastro;
	private EnumStatus status;
	private EnumTipo tipo;
	
	// construtor vazio
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String email, String senha, String telefone, LocalDate dataNascimento,
			LocalDate dataCadastro, EnumStatus status, EnumTipo tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.tipo = tipo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public EnumTipo getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipo tipo) {
		this.tipo = tipo;
	}

}
