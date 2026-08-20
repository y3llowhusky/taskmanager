package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.y3llowhusky.taskmanager.model.EnumSituacao;
import br.com.y3llowhusky.taskmanager.model.Tarefa;
import br.com.y3llowhusky.taskmanager.util.ConnectionFactory;

public class TarefaRepository {

	public List<Tarefa> listarTodas() {
		
		List<Tarefa> tarefas = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM tarefas";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				
				String situacao = rs.getString("situacao");
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(rs.getLong("responsavel_id"));
				tarefa.setPrazoEntrega(rs.getDate("prazo_entrega").toLocalDate());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
	}
	
}
