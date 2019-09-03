package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Pessoa;

public class PessoaDAO implements PessoaInDAO 
{
      private Connection conexao = null;
      
      public PessoaDAO(Connection _conn)
      {
    	  this.conexao = _conn;
      }
      
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		
      String SQL = "insert into pessoa (nome, email, tel) values (?,?,?)";

      PreparedStatement ps = this.conexao.prepareStatement(SQL);
      
      ps.setString(1, _objeto.getNome());
      ps.setString(2, _objeto.getEmail());
      ps.setString(3, _objeto.getTelefone());
      
      ps.execute();
	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, email from pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) 
		{
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			Pessoa p = new Pessoa (id, nome, email, telefone);
			
			pessoas.add(p);
			
			/*Pessoa p = new Pessoa();
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
			
			pessoas.add(p); */
		
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
