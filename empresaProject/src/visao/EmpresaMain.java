package visao;

import java.util.ArrayList;
import java.util.Scanner;

import aplicacao.pedido;

public class EmpresaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		int op;
		boolean achou;
		
		  
		 ArrayList<pedido> ListaPedidos = new ArrayList<pedido>();
		 
		  do{
	        	achou = false;
	            System.out.println();
	            System.out.println("    Menu Principal");
	            System.out.println("------------------------");
	            System.out.println("1 - Fazer pedido");
	            System.out.println("2 - Confirmar entrega");
	            System.out.println("3 - Ver pedidos confirmados");
	            System.out.println("4 - Ver pedidos entregues");
	            System.out.println("5 - Sair do Sistema");
	            System.out.println("Qual a opção desejada? ");
	            op = ler.nextInt();
	
		  }while(op!=5);

	}
	
}
	
