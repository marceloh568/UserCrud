package br.com.usercrud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.usercrud.util.ProjetoException;

public class ConexaoFactory{

	public static Connection getConnection() throws ProjetoException{

		String url = "jdbc:postgresql://localhost:5432/banco_local";
		String usuario = "postgres";
		String senha = "post";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con;
			con = DriverManager.getConnection(url, usuario, senha);
			con.setAutoCommit(false);
			return con;
		} catch (ClassNotFoundException cnf) {
			FacesMessage msg = null;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Driver de conexao com o banco nao encontrado \n Mensagem original: " + cnf.getMessage(), "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			throw new ProjetoException(msg.toString());
		} catch (SQLException sql) {
			FacesMessage msg = null;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nao foi possivel abrir a conexao com o banco \n Mensagem original: " + sql.getMessage(), "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			throw new ProjetoException(sql.getMessage());
		}
	}

}