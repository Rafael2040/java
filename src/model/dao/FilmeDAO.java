package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.filme;

public class FilmeDAO {

	public void create(filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO FILME (titulo, categoria, sinopse, tempo, imagem3d, dublado) VALUES" +"(?,?,?,?,?,?)");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getTempo());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(6, f.isDublado());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso !!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+e );
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}	
	}
	public List<filme> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<filme> filmes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM filme");
			rs = stmt.executeQuery();
			while(rs.next()) {
				filme f = new filme();
				f.setIdFilme(rs.getInt("idFilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTempo(rs.getInt("tempo"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
				f.setImagem3d(rs.getBoolean("imagem3d"));
				f.setDublado(rs.getBoolean("dublado"));
				filmes.add(f);
			}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações no BD: "+e );
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return filmes;
	}	
}
