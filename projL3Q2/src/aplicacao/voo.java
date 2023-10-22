package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class voo extends data{
	private int numeroVoo;
	private List<Boolean> ocupacaoCadeiras;
	
	public voo(int dia, int mes, int ano, int numeroVoo) {
		super(dia, mes, ano);
		this.numeroVoo = numeroVoo;
		int numeroCadeiras = 0;
		inicializarCadeiras(numeroCadeiras);
	}
	
	private void inicializarCadeiras(int numeroCadeiras) {
		ocupacaoCadeiras = new ArrayList<>(numeroCadeiras);
		for(int i =0; i< numeroCadeiras; i++) {
			ocupacaoCadeiras.add(false);
		}
	}
	
	public int proximoLivre() {
		for(int i = 0; i< ocupacaoCadeiras.size(); i++) {
			if(!ocupacaoCadeiras.get(i)) {
				ocupacaoCadeiras.set(i, true);
				return i+1;
			}
		}
		return -1;
	}
	
	public boolean verifica(int numeroCadeiras) {
		if(numeroCadeiras >=1 && numeroCadeiras <= ocupacaoCadeiras.size()) {
			return ocupacaoCadeiras.get(numeroCadeiras - 1);
		}else {
			System.out.println("Número de cadeira inválido.");
            return false;
		}
	}
	
	public boolean ocupa(int numeroCadeiras) {
		  if (numeroCadeiras >= 1 && numeroCadeiras <= ocupacaoCadeiras.size()) {
	            if (!ocupacaoCadeiras.get(numeroCadeiras - 1)) {
	                ocupacaoCadeiras.set(numeroCadeiras - 1, true); // Marca a cadeira como ocupada
	                return true; // Operação bem-sucedida
	            } else {
	                System.out.println("A cadeira já está ocupada.");
	                return false; // Cadeira já está ocupada
	            }
	        } else {
	            System.out.println("Número de cadeira inválido.");
	            return false; // Número da cadeira inválido
	        }
	    }
	
	
	public int vagas() {
		  int vagasDisponiveis = 0;
	        for (boolean ocupada : ocupacaoCadeiras) {
	            if (!ocupada) {
	                vagasDisponiveis++;
	            }
	        }
	        return vagasDisponiveis;         
	}
	
	public int getVoo() {
		return numeroVoo;
	}
	
	public data getData() {
		data date = new data(10, 11, 2004);
		return date;
	}
	
	public data clone(data maisData) {
	    return new data(maisData.getDia(), maisData.getMes(), maisData.getAno());
	}

}
