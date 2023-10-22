package dominio;

public class visionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		calculadoraMelhorada minhaCalc = new calculadoraMelhorada();
		
		System.out.println(minhaCalc.calcular('+',2,1));
		System.out.println("�ltima opera��o: " + minhaCalc.verUltimaOperacao());

		System.out.println(minhaCalc.calcular(2, 1));
		System.out.println("�ltima opera��o: " + minhaCalc.verUltimaOperacao());

		calculadora c1 = new calculadora();
		
		System.out.println(c1.calcular('*', 3, 4));
		
	}

}
