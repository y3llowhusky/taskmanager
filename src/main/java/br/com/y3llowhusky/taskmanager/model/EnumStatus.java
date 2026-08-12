package br.com.y3llowhusky.taskmanager.model;

public enum EnumStatus {
	// Status possíveis para um usuário
	ATIVO("Ativo"), INATIVO("Inativo");
	
	private String descricao;
	
	// Construtor do enum contendo descrição como atributo
	private EnumStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
