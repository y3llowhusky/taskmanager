package br.com.y3llowhusky.taskmanager.model;

import java.time.LocalDate;

public class Tarefa {
	
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private EnumSituacao situacaoTarefa;
	private Long usuarioId;
	
	public Tarefa() {
		
	}

	public Tarefa(Long id, String nome, String descricao, LocalDate dataCriacao, EnumSituacao situacaoTarefa,
			Long usuarioId) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.situacaoTarefa = situacaoTarefa;
		this.usuarioId = usuarioId;
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

	public EnumSituacao getSituacaoTarefa() {
		return situacaoTarefa;
	}

	public void setSituacaoTarefa(EnumSituacao situacaoTarefa) {
		this.situacaoTarefa = situacaoTarefa;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
}
