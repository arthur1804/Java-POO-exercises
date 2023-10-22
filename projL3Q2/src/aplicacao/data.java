package aplicacao;

import java.util.Calendar;
import java.time.LocalDate;

public class data {
	private int dia;
	private int mes;
	private String mesExtenso;
	private int ano;
	
	
	public data(int dia, int mes, int ano) {
		if(verificarData( dia,  mes, ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}else {
			 this.dia = 1;
	         this.mes = 1;
	         this.ano = 1;
	         System.out.println("Data inválida. Configurando como 01/01/0001.");
		}
	
	}
	
	public boolean verificarData(int dia, int mes, int ano) {
		Calendar anual = Calendar.getInstance();
		anual.setLenient(false);
		
		  try {
	            anual.set(ano, mes - 1, dia); // O mês no Calendar começa do zero (janeiro = 0)
	            anual.getTime(); // Tentar converter para verificar se a data é válida
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}
	
	public int compara(data outraData) {
		LocalDate dataAtual = LocalDate.of(this.ano,this.mes,this.dia);
		LocalDate dataParametro = LocalDate.of(outraData.ano, outraData.mes, outraData.dia);
		
		return dataAtual.compareTo(dataParametro);
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public String getMesExtenso() {
		return mesExtenso;
	}
	
	public int getAno() {
		return ano;
	}
	
	public data clone(data maisData) {
	    return new data(maisData.dia, maisData.mes, maisData.ano);
	}

}
