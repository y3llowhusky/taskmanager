package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.Date;
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
				tarefa.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
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
	
	public Tarefa buscarPorId(Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		Tarefa tarefa = null;
		String sql = "SELECT * FROM TAREFAS WHERE id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				tarefa = new Tarefa();
				String situacao = rs.getString("situacao");
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(rs.getLong("responsavel_id"));
				tarefa.setPrazoEntrega(rs.getObject("prazo_entrega", LocalDate.class));
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefa;
		
	}
	
	public List<Tarefa> listarPorCriador(Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		List<Tarefa> tarefas = new ArrayList<>();
		String sql = "SELECT * FROM tarefas WHERE criador_id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				String situacao = rs.getString("situacao");
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(rs.getLong("responsavel_id"));
				tarefa.setPrazoEntrega(rs.getObject("prazo_entrega", LocalDate.class));
				
				tarefas.add(tarefa);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
		
	}
	
	public List<Tarefa> listarPorResponsavel(Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		List<Tarefa> tarefas = new ArrayList<>();
		String sql = "SELECT * FROM tarefas WHERE responsavel_id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				String situacao = rs.getString("situacao");
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(rs.getLong("responsavel_id"));
				tarefa.setPrazoEntrega(rs.getObject("prazo_entrega", LocalDate.class));
				
				tarefas.add(tarefa);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
		
	}
	
	public List<Tarefa> listarSemResponsavel() {
		
		Connection con = ConnectionFactory.getConnection();
		List<Tarefa> tarefas = new ArrayList<>();
		String sql = "SELECT * FROM tarefas WHERE responsavel_id IS NULL";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				String situacao = rs.getString("situacao");
				
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
				tarefa.setSituacao(EnumSituacao.valueOf(situacao));
				tarefa.setCriadorId(rs.getLong("criador_id"));
				tarefa.setResponsavelId(rs.getLong("responsavel_id"));
				tarefa.setPrazoEntrega(rs.getObject("prazo_entrega", LocalDate.class));
				
				tarefas.add(tarefa);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tarefas;
		
	}
	
	public void concluir(Tarefa tarefa, Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE tarefas SET situacao = 'CONCLUIDA' WHERE id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void cancelar(Tarefa tarefa, Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE tarefas SET situacao = 'CANCELADA' WHERE id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void editar(Tarefa tarefa, Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE tarefas SET nome = ?, descricao = ?, responsavel_id = ?, prazo_entrega = ?"
				+ "WHERE id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			Date prazoEntrega = Date.valueOf(tarefa.getPrazoEntrega());
			
			ps.setString(1, tarefa.getNome());
			ps.setString(2, tarefa.getDescricao());
			ps.setLong(3, tarefa.getResponsavelId());
			ps.setDate(4, prazoEntrega);
			ps.setLong(5, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
