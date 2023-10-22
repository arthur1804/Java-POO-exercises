package visao;

import java.util.Scanner;

import dominio.musica;

import java.util.ArrayList;
import java.util.Collections;

public class playlists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <musica> playlist = new ArrayList<>();
		Scanner ler = new Scanner(System.in);
		int op;
		
		System.out.println("escolha uma opcão\r\n");
		
		System.out.println("---------------------------------------------------------\r\n");
		System.out.println("MENU PRINCIPAL\r\n");
		System.out.println("---------------------------------------------------------\r\n");
		System.out.println("1 - ADICIONAR MUSICA\r\n");
		System.out.println("2- EXCLUIR MUSICA\r\n");
		System.out.println("3- TOCAR MUSICA ESPECIFICA PELO TITULO\r\n");
		System.out.println("4- TOCAR MUSICA DE UM CANTOR\r\n");
		System.out.println("5- TOCAR MUSICA EM SEQUENCIA\r\n");
		System.out.println("6- TOCAR MUSICA EMBARALHADAr\n");
		System.out.println("7- VER MUSICAS DA PLAYLIST\r\n");
		System.out.println("8- SAIR\r\n");
		System.out.println("---------------------------------------------------------\r\n");
		
		do {
			
			op = ler.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("informe o nome do artista\r\n");
				String artista = ler.next();
				System.out.println("diga o titulo da musica para adicionar\r\n");
				String titulo = ler.next();
				System.out.println("2- digite a duracao em segundos da musica\r\n");
				int duracao = ler.nextInt();
				
				boolean musicaExistente = false;
			    for (musica m : playlist) {
			        if (m.getTitulo().equalsIgnoreCase(titulo) && m.getArtista().equalsIgnoreCase(artista)) {
			            musicaExistente = true;
			            System.out.println("Esta música já está na playlist.");
			            break;
			        }
			    }
			    if (!musicaExistente) {
			        playlist.add(new musica(titulo, artista, duracao));
			        System.out.println("Música adicionada com sucesso!");
			    }
				break;
			case 2:
				System.out.println("informe o nome da musica que deseja excluir");
				
				String tituloExcluir= ler.next();
				boolean encontrou = false;
				int i;
				
				for(i=0;i<playlist.size();i++) {
					if(playlist.get(i).getTitulo().equalsIgnoreCase(tituloExcluir)) {
						playlist.remove(i);
						encontrou = true;
						System.out.println("Música excluída com sucesso!");
				        break;
					}
				}
				break;
			case 3:
				System.out.println("escolha uma musica para tocar pelo titulo");
				titulo = ler.next();
				
				for(musica m : playlist) {
					if(m.getTitulo().equalsIgnoreCase(titulo)) {
					System.out.println("Tocando a música: " + m.getTitulo());
					
				for(i=0;i<m.getDuracao(); i++)
				{
				 try{
				 Thread.sleep(1000); // pausa de 1 segundo
				 }catch(InterruptedException e){
				 System.out.println("Erro na execução da música: "+e.getMessage());
				 }
				 System.out.print("|");

				} 
				break;
				} 
			}
				
				break;
			case 4:
				 System.out.println("Informe o nome do cantor:");
				 String cantorTocar = ler.next();
				 
				 for(musica m : playlist) {
						if(m.getArtista().equalsIgnoreCase(cantorTocar)) {
						System.out.println("Tocando a música: " + m.getTitulo() + " do cantor " + m.getArtista());
						
					for(i=0;i<m.getDuracao(); i++)
					{
					 try{
					 Thread.sleep(1000); // pausa de 1 segundo
					 }catch(InterruptedException e){
					 System.out.println("Erro na execução da música: "+e.getMessage());
					 }
					 System.out.print("|");

					} 
					break;
					} 
				}
				break;
			case 5:
			    int tempoTotalReproducao = 0;

			    // Calcula o tempo total de reprodução somando as durações de todas as músicas na playlist
			    for (musica m : playlist) {
			        tempoTotalReproducao += m.getDuracao();
			    }

			    System.out.println("Tocando as músicas em sequência...");

			    // Reproduz as músicas em sequência
			    for (musica m : playlist) {
			        System.out.println("Tocando a música: " + m.getTitulo());

			        for (int cont = 0; cont < m.getDuracao(); cont++) {
			            try {
			                Thread.sleep(1000); // pausa de 1 segundo
			            } catch (InterruptedException e) {
			                System.out.println("Erro na execução da música: " + e.getMessage());
			            }
			            System.out.print("|");
			        }

			        System.out.println(); // Para pular uma linha após a simulação
			    }

			    System.out.println("Todas as músicas foram reproduzidas em sequência.");
			    break;
			case 6:
				Collections.shuffle(playlist);
				
				 for (musica m : playlist) {
				     System.out.println("Tocando a música: " + m.getTitulo());

				     for (int cont = 0; cont < m.getDuracao(); cont++) {
				          try {
				             Thread.sleep(1000); // pausa de 1 segundo
				         } catch (InterruptedException e) {
				                System.out.println("Erro na execução da música: " + e.getMessage());
				        }
				         System.out.print("|");
				        }

				      System.out.println(); // 
				    }

				    System.out.println("Todas as músicas foram embaralhadas.");
				    
				break;
			case 7:
				System.out.println("Músicas na playlist:");
				
				 for (musica m : playlist) {
				    System.out.println("Título: " + m.getTitulo() + " | Artista: " + m.getArtista() + " | Duração: " + m.getDuracao() + " segundos");
				    }
				break;
			case 8: System.out.println("saindo do programa...\r\n");
				System.exit(0);
				break;
			}
			
		}while(op!=8);
		
		ler.close();
		
	}

}


