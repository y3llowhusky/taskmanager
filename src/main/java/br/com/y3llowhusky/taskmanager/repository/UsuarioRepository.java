package br.com.y3llowhusky.taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.y3llowhusky.taskmanager.model.EnumStatus;
import br.com.y3llowhusky.taskmanager.model.EnumTipo;
import br.com.y3llowhusky.taskmanager.model.Usuario;
import br.com.y3llowhusky.taskmanager.util.ConnectionFactory;

public class UsuarioRepository {
	
	public List<Usuario> listarTodos() {
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM usuarios";		
		List<Usuario> usuarios = new ArrayList<>();
		
		
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
		String sql = "SELECT * FROM usuarios WHERE usuario_id = ?";		
		Usuario usuario = null;
		
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
		String sql = "SELECT * FROM usuarios WHERE email = ?";		
		Usuario usuario = null;
		
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
}
