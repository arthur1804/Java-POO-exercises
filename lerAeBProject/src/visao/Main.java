package visao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int[] A = new int[5];
		int[] B = new int[5];
		int[] C = new int[5];
		
		int i;
		System.out.println("digite A");
		for(i=0;i<5;i++) {
			A[i] = teclado.nextInt();
	
		}
		
		System.out.println("digite B");
		for(i=0;i<5;i++) {
			B[i] = teclado.nextInt();
	
		}
		
		int soma = 0;
		for(i=0;i<5;i++) {
			soma += A[i];
	
		}
			
		System.out.println("Resultado de A: " +soma);
		
		System.out.println("Resultado da soma entre A e B: ");

		for(i=0;i<5;i++) {
			C[i] = A[i] + B[i];
			System.out.print(C[i] + " ");
		}
		
	}

}

