package persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement; 

import dominio.contato;

public class contatoDao {
	private conexao c;
	private String REL = "select * from \"contato\"";
	private String BUS = "select * from \"contato\" where \"id\"=? ";
	private String INC = "insert into \"contato\" (\"id\",\"nome\",\"telefone\",\"email\") values (?,?,?,?)";
	private String DEL = "delete from \"contato\" where \"id\" = ?";
	private String AT = "update \"contato\" set \"nome\" = ?, \"telefone\" = ?, \"email\" = ? where \"id\" = ? ";
	
	public contatoDao() {
		c = new conexao("jdbc:postgresql://localhost:5432/agenda","postgres","arthur45" );
	}
	
	public void remove(int idAux) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(DEL);
			instrucao.setInt(1, idAux);
			int linhasAfetadas = instrucao.executeUpdate();
	        
	        if (linhasAfetadas > 0) {
	            System.out.println("Contato excluído com sucesso");
	        }

		}catch(Exception e) {
			System.out.println("Erro na exclusão");
		 } finally {
		        c.desconectar();
		    }
	}
	
	public void include(contato pessoa) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(INC);
			instrucao.setInt(1, pessoa.getId());
			instrucao.setString(2, pessoa.getNome());
			instrucao.setString(3, pessoa.getTelefone());
			instrucao.setString(4, pessoa.getEmail());
			int linhasAfetadas = instrucao.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Contato incluido com sucesso");
			}
			
		}catch(Exception e) {
			System.out.println("Erro na inclusão");
			 e.printStackTrace();
		 } finally {
		        c.desconectar();
		    }
	}
	
	
	public void update(contato pessoa) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(AT);
			instrucao.setInt(1, pessoa.getId());
			instrucao.setString(2, pessoa.getNome());
			instrucao.setString(3, pessoa.getTelefone());
			instrucao.setString(4, pessoa.getEmail());
			int linhasAfetadas = instrucao.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Contato atualizado com sucesso!");
			}else {
				System.out.println("não foi possivel atualizar");
			}
			
		}catch(Exception e) {
			System.out.println("Erro na alteração");
		 } finally {
		        c.desconectar();
		    }
	}
	
	public contato search(int idAux) {
		contato pessoa = null;
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(BUS);
			instrucao.setInt(1, idAux);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				pessoa = new contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
			}
		}catch(Exception e){
			System.out.println("Erro na busca");
		 } finally {
		        c.desconectar();
		    }
		return pessoa;
	}
	
	public ArrayList<contato> generateReport() {
		contato pessoa;
		ArrayList<contato> list= new ArrayList<contato>();
		try {
			c.conectar();
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(REL);
			while(rs.next()) {
				pessoa = new contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
				list.add(pessoa);
			} 
			
		}catch(Exception e) {
			System.out.println("Erro no relatorio!");
		} finally {
	        c.desconectar();
	    }
		return list;
	}
	
	public contato searchByName(String nome) {
	    contato pessoa = null;
	    try {
	        c.conectar();
	        PreparedStatement instrucao = c.getConexao().prepareStatement("SELECT * FROM \"Contato\" WHERE \"nome\" = ?");
	        instrucao.setString(1, nome);
	        ResultSet rs = instrucao.executeQuery();
	        if (rs.next()) {
	            pessoa = new contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
	        }
	        
	    } catch (Exception e) {
	        System.out.println("Erro na busca por nome");
	    } finally {
	        c.desconectar();
	    }
	    return pessoa;
	}
}


