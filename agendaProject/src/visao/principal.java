package visao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.contato;
import persistencia.contatoDao;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		int op, i,  idAux;
		contatoDao cDao = new contatoDao();
		ArrayList<contato> agenda = new ArrayList<contato>();
		contato c;
		
		do {
		System.out.println("---------------------------------------------------------\r\n");
		System.out.println("MENU PRINCIPAL\r\n");
		System.out.println("---------------------------------------------------------\r\n");
		System.out.println("1 - BUSCAR CONTATO\r\n");
		System.out.println("2 - INCLUIR CONTATO\r\n");
		System.out.println("3 - ALTERAR CONTATO\r\n");
		System.out.println("4 - EXCLUIR CONTATO\r\n");
		System.out.println("5 - RELATÓRIO DE CONTATOS\r\n");
		System.out.println("6 - SAIR DO SISTEMA\r\n");
		
		System.out.println("digite a opção desejada:\r\n");
		op = teclado.nextInt();
		teclado.nextLine();
		
		switch(op) {
		case 1:
			
			int opcao= 0;
			
			do {
				
				System.out.println("MENU SECUNDÁRIO\r\n");
				System.out.println("---------------------------------------------------------\r\n");
				System.out.println("1 - BUSCAR PELO ID\r\n");
				System.out.println("2 - INCLUIR PELO NOME\r\n");
				System.out.println("3 - VOLTAR AO MENU PRINCIPAL\r\n");
				
				System.out.println("escolha a opcao desejada\r\n");
				opcao = teclado.nextInt();
				teclado.nextLine();
				
				switch(opcao) {
				case 1:
					System.out.println("Buscando Contato...");
					System.out.println("Digite o id do contato desejado: ");
					idAux = teclado.nextInt();
					teclado.nextLine();
					c = cDao.search(idAux);
					if(c==null) {
						System.out.println("Contato n�o cadastrado");
					}else {
						System.out.println("Contato "+c.getId()+ " localizado!");
						System.out.println("Nome: "+c.getNome());
						System.out.println("Telefone: "+c.getTelefone());
						System.out.println("E-mail: "+c.getEmail());
					}
					break;
				case 2:
					System.out.println("Incluindo Contato...");
					System.out.println("Digite o nome do contato desejado: ");
					String nomeContato = teclado.nextLine();
					c = cDao.searchByName(nomeContato);
					if(c==null) {
						c = new contato();
						System.out.println("Digite o id do contato: ");
				        c.setId(teclado.nextInt());
				        teclado.nextLine();
						System.out.println("Digite o telefone: ");
						c.setTelefone(teclado.nextLine());
						System.out.println("Digite o email: ");
						c.setEmail(teclado.nextLine());
						cDao.include(c);
						System.out.println("inclusão feita com sucesso!");
					}else {
						System.out.println("contato ja cadastrado!");
					}
					break;
				case 3: System.out.println("voltando ao menu principal...");
					break;
				}
				
			}while(opcao!=3);
			
			break;
		case 2: 
			System.out.println("inclusao de Contatos...");
			System.out.println("Digite o id do contato desejado: ");
			idAux = teclado.nextInt();
			teclado.nextLine();
			c = cDao.search(idAux);
			if(c==null) {
				c = new contato();
				c.setId(idAux);
				System.out.println("Digite o nome: ");
				c.setNome(teclado.nextLine());
				System.out.println("Digite o telefone: ");
				c.setTelefone(teclado.nextLine());
				System.out.println("Digite o email: ");
				c.setEmail(teclado.nextLine());
				cDao.include(c);
				System.out.println("inclusão feita com sucesso!");
			}else {
				System.out.println("contato ja cadastrado!");
			}
			break;
		case 3:
			System.out.println("alteracao de Contatos...");
			System.out.println("Digite o id do contato desejado: ");
			idAux = teclado.nextInt();
			teclado.nextLine();
			c = cDao.search(idAux);
			if(c==null) {
				System.out.println("contato nao cadastrado! ");
			}else {
				c = new contato();
				c.setId(idAux);
				System.out.println("Digite o novo nome do contato: ");
				c.setNome(teclado.nextLine());
				System.out.println("Digite o novo telefone: ");
				c.setTelefone(teclado.nextLine());
				System.out.println("Digite o novo email: ");
				c.setEmail(teclado.nextLine());
				cDao.update(c);
				System.out.println("alteracao feita com sucesso!");
			}
			break;
		case 4:
			System.out.println("exclusao de Contatos...");
			System.out.println("digite o id do contato desejado: ");
			idAux = teclado.nextInt();
			teclado.nextLine();
			c = cDao.search(idAux);
			if(c==null) {
				System.out.println("contato nao cadastrado! ");
			}else {
				cDao.remove(idAux);
				System.out.println("exclusao feita com sucesso! ");
			}
			break;
		case 5:
			System.out.println("Relatorio de Contatos...");
			agenda = cDao.generateReport();
			for(i=0; i<agenda.size(); i++) {
				System.out.println("\t"+agenda.get(i).getId()+"\t"+agenda.get(i).getNome()+"\t"+
						agenda.get(i).getTelefone()+"\t"+agenda.get(i).getEmail());
			}
			break;
		case 6:
			System.out.println("Fim de Programa");
			break;
		default: System.out.println("opcao invalida!");
		
		}
		
		}while(op!=6);
	}

}
