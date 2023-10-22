package dominio;

public class musica {
	 private String titulo;
	 private String artista;
	 private int duracao;
	 
	 public musica(String titulo, String artista, int duracao) {
		 this.titulo = titulo;
		 this.artista = artista;
		 this.duracao = duracao;
	 }
	 
	 public String  getTitulo() {
		 return titulo;
	 }
	 
	 public String getArtista() {
		 return artista;
	 }
	 
	 public int getDuracao() {
		 return duracao;
	 }
	 
	 public void setTitulo(String titulo){
		 this.titulo = titulo;
	 }
	 
	 public void setArtista(String artista) {
		 this.artista = artista;
	 }
	 
	 public void setDuracao(int duracao) {
		 this.duracao = duracao;
	 }
	 
	
}
