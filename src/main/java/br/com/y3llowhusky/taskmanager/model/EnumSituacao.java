package br.com.y3llowhusky.taskmanager.model;

public enum EnumSituacao {
	PENDENTE("Pendente"), CONCLUIDA("Concluída");
	
	private String descricao;
	
	private EnumSituacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
