package aplicacao;

public class cachorro {
	private String nome;
	private String raca;
	private int idade;
	
	
public cachorro(String nome, String raca, int idade) {
	this.nome = nome;
	this.raca = raca;
	this.idade = idade;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getRaca() {
	return raca;
}
public void setRaca(String raca) {
	this.raca = raca;
}
public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
}

public String informarEstado() {
	return nome+","+raca+","+idade;
}

public cachorro clonarCachorro() {
	return new cachorro(nome, raca, idade);
}

public boolean equals(Object obj) {
    cachorro c = (cachorro) obj;
    if ((this.nome == c.getNome()) &&
       (this.raca == c.getRaca()) &&
       (this.idade == c.getIdade())) {
        return true;
    } else {
        return false;
    
}
}
}


