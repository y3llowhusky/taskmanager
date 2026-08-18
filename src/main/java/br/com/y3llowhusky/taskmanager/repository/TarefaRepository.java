package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				
				tarefa.setNome(rs.getString("nome"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
	}
	
}
