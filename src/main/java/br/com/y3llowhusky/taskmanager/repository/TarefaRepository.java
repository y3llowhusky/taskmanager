package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
				Long responsavelId = rs.getObject("responsavel_id", Long.class);
				LocalDate prazoEntrega = rs.getObject("prazo_entrega", LocalDate.class);
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(responsavelId);
				tarefa.setPrazoEntrega(prazoEntrega);
				
				tarefas.add(tarefa);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
		
	}
	
}
