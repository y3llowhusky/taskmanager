package br.com.y3llowhusky.taskmanager.model;

import java.time.LocalDate;

public class Tarefa {
	
	// atributos da tarefa
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private EnumSituacao situacao;
	private Long criadorId;
	private Long responsavelId;
	private LocalDate prazoEntrega;
	
	// construtor vazio
	public Tarefa() {
		
	}

	public Tarefa(Long id, String nome, String descricao, LocalDate dataCriacao, EnumSituacao situacao, Long criadorId,
			Long responsavelId, LocalDate prazoEntrega) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.situacao = situacao;
		this.criadorId = criadorId;
		this.responsavelId = responsavelId;
		this.prazoEntrega = prazoEntrega;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public EnumSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}

	public Long getCriadorId() {
		return criadorId;
	}

	public void setCriadorId(Long criadorId) {
		this.criadorId = criadorId;
	}

	public Long getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(Long responsavelId) {
		this.responsavelId = responsavelId;
	}

	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(LocalDate prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

}
