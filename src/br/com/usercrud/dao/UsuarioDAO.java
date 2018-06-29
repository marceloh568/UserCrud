package br.com.usercrud.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.usercrud.model.Usuario;
import br.com.usercrud.factory.ConexaoFactory;

public class UsuarioDAO {
	
	public void salvar(Usuario u) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO usuario (descricao_usuario, cpf_usuario, email_usuario, data_nascimento_usuario, senha_usuario) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");

		Connection conexao = ConexaoFactory.con();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setString(1, u.getDescricao());
		ps.setString(2, u.getCpf());
		ps.setString(3, u.getEmail());
		ps.setDate(4, new java.sql.Date(u.getDataNascimento().getTime()));
		ps.setString(5, u.getSenha());

		ps.executeUpdate();
		conexao.close();
	}

	public ArrayList<Usuario> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_usuario, descricao_usuario, cpf_usuario, email_usuario, data_nascimento_usuario, senha_usuario ");
		sql.append("FROM usuario ORDER BY descricao_usuario ASC");

		Connection conexao = ConexaoFactory.con();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario u = new Usuario();
			u.setId(rs.getLong("id_usuario"));
			u.setDescricao(rs.getString("descricao_usuario"));
			u.setCpf(rs.getString("cpf_usuario"));
			u.setEmail(rs.getString("email_usuario"));
			u.setDataNascimento(rs.getDate("data_nascimento_usuario"));
			u.setSenha(rs.getString("senha_usuario"));

			lista.add(u);
		}

		conexao.close();
		return lista;	
	}

	public void excluir(Usuario u) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM usuario " + "WHERE id_usuario = ?");

		Connection conexao = ConexaoFactory.con();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setLong(1, u.getId());

		ps.executeUpdate();
		
		conexao.close();
	}

	public void editar(Usuario u) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario ");
		sql.append("SET descricao_usuario = ?, cpf_usuario = ?, ");
		sql.append("email_usuario = ?, data_nascimento_usuario = ?, senha_usuario = ? ");
		sql.append("WHERE id_usuario = ?");

		Connection conexao = ConexaoFactory.con();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());

		ps.setString(1, u.getDescricao());
		ps.setString(2, u.getCpf());
		ps.setString(3, u.getEmail());
		ps.setDate(4, new java.sql.Date(u.getDataNascimento().getTime()));
		ps.setString(5, u.getSenha());
		ps.setLong(6, u.getId());

		ps.executeUpdate();
		
		conexao.close();
	}
}
