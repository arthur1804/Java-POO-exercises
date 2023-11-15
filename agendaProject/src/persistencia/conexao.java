package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
	private String usuario;
	private String senha;
	private String caminho;
	private Connection con;
	
public conexao(String c, String u, String s) {
	caminho = c;
	usuario = u;
	senha = s;
}

public void conectar () {
	try {
	Class.forName("org.postgresql.Driver");
	
	con = DriverManager.getConnection(caminho, usuario, senha);
	}catch(Exception e) {
		System.out.println("erro na conexao!" +e.getMessage());
	}
	
}

public void desconectar () {
	try {
		con.close();
	}catch(Exception e) {
		System.out.println("nao foi possivel desconectar" +e.getMessage());
	}
}

public Connection getConexao(){
	return con;
}

}


