package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.sql.Date;

import br.com.y3llowhusky.taskmanager.model.EnumStatus;
import br.com.y3llowhusky.taskmanager.model.EnumTipo;
import br.com.y3llowhusky.taskmanager.model.Usuario;
import br.com.y3llowhusky.taskmanager.util.ConnectionFactory;

public class UsuarioRepository {
	
	public List<Usuario> listarTodos() {
		
		Connection con = ConnectionFactory.getConnection();
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";
		
		
		try (con) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				
				String usuarioStatus = rs.getString("status"); 
				String usuarioTipo = rs.getString("usuario_tipo");
				
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				usuario.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
				usuario.setStatus(EnumStatus.valueOf(usuarioStatus));
				usuario.setTipoUsuario(EnumTipo.valueOf(usuarioTipo));
				
				usuarios.add(usuario);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public Usuario buscarPorId(Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE usuario_id = ?";		
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				usuario = new Usuario();
				
				String usuarioStatus = rs.getString("status");
				String usuarioTipo = rs.getString("usuario_tipo");
				
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				usuario.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
				usuario.setStatus(EnumStatus.valueOf(usuarioStatus));
				usuario.setTipoUsuario(EnumTipo.valueOf(usuarioTipo));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
	public Usuario buscarPorEmail(String email) {
		
		Connection con = ConnectionFactory.getConnection();
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE email = ?";	
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				usuario = new Usuario();
				String usuarioStatus = rs.getString("status");
				String usuarioTipo = rs.getString("usuario_tipo");
				
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				usuario.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
				usuario.setStatus(EnumStatus.valueOf(usuarioStatus));
				usuario.setTipoUsuario(EnumTipo.valueOf(usuarioTipo));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
	public void criarUsuario (Usuario usuario) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, "
					+ "status, tipo_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			Date dataCadastro = Date.valueOf(LocalDate.now());
			Date dataFormatada = Date.valueOf(usuario.getDataNascimento());
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTelefone());
			ps.setDate(5, dataFormatada);
			ps.setDate(6, dataCadastro);
			ps.setString(7, usuario.getStatus().name());
			ps.setString(8, usuario.getTipoUsuario().name());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void editarUsuario(Usuario usuario) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, tipo_usuario = ?"
				+ " WHERE usuario_id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getTelefone());
			ps.setString(4, usuario.getTipoUsuario().name());
			ps.setLong(5, usuario.getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void desativarUsuario(Long id) {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE usuarios SET status = 'INATIVO' WHERE usuario_id = ?";
		
		try (con) {
			
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
