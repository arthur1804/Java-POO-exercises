package visao;

import aplicacao.cachorro;

public class Main {

	public static void main(String[] args) {
		
		
		cachorro c1 = new cachorro("cachorro sem nome", "nenhuma raca definida", 0);
		
		System.out.println("Nome: " +c1.getNome());
		System.out.println("raca: " +c1.getRaca());
		System.out.println("idade: " +c1.getIdade());

		c1.setNome("joaquim");
		c1.setRaca("vira-lata");
		c1.setIdade(5);
		
		System.out.println("informar novo estado" +c1.informarEstado());
		
		
		cachorro c2 = c1.clonarCachorro();
		
		if("ana"=="ana") System.out.println(true);
		if(c1.informarEstado().equals(c2.informarEstado())) {
			System.out.println("Os estados s�o iguais");
		}else {
			System.out.println("Os estados n�o s�o iguais");
		}
		
		System.out.println("Estado do clone: "+c2.informarEstado());
		
		if(c1.equals(c2)) { //sobrescri��o (ou sobreposi��o) do m�todo equals()
			System.out.println("Os estados s�o iguais");
		}else {
			System.out.println("Os estados n�o s�o iguais");
		}

	}

}
