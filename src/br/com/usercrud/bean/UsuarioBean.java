package br.com.usercrud.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.usercrud.dao.UsuarioDAO;
import br.com.usercrud.model.Usuario;
import br.com.usercrud.util.JSFUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;

	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensFiltrados;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}

	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			alertarErroGeral(ex);
		}

	}

	public void carregarListagem() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			itens = dao.listar();
			
		} catch (SQLException ex) {
			alertarErroGeral(ex);
		}
	}

	public void prepararNovo() {
		usuario = new Usuario();
	}

	public void novoUsuario() {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itens = dao.listar();

			JSFUtil.adicionarMenssagemSucesso("Usuário salvo com sucesso!");
		} catch (SQLException ex) {
			alertarErroGeral(ex);
		}

	}

	public void excluir() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuario);

			itens = dao.listar();

			JSFUtil.adicionarMenssagemSucesso("Usuário excluído com êxito!");
		} catch (SQLException ex) {
			alertarErroGeral(ex);
		}
	}

	public void editar() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.editar(usuario);

			itens = dao.listar();

			JSFUtil.adicionarMenssagemSucesso("Usuário editado com êxito!");
		} catch (SQLException ex) {
			alertarErroGeral(ex);
		}
	}
	
	private void alertarErroGeral(SQLException exception){
		exception.printStackTrace();
		JSFUtil.adicionarMenssagemErro("Ocorreram erros: "
				+ exception.getMessage());
	}
	
	public Date getDataAtual(){
		return new Date();
	}
}
