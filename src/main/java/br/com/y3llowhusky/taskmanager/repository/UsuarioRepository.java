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
		List<Usuario> usuarios = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM usuarios";
		
		try (con) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDataNascimento(rs.getDate("data_nascimento"));
				// CONTINUAR DAQUI PRA BAIXO!!
				rs.getDate("data_cadastro");
				rs.getString("status");
				rs.getString("tipo_usuario");
				
				EnumStatus.valueOf("ATIVO");
				EnumStatus.valueOf("INATIVO");
				EnumTipo.valueOf("PADRAO");
				EnumTipo.valueOf("ADMIN");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
