package br.com.y3llowhusky.taskmanager.model;

public enum EnumTipo {
	// Tipos de usuário existentes
	PADRAO("Padrão"), ADMIN("Administrador");
	
	private String descricao;
	
	// Construtor do enum contendo descrição como atributo
	private EnumTipo(String descricao) {
		this.descricao = descricao;
	}
	
	private String getDescricao() {
		return this.descricao;
	}
}
