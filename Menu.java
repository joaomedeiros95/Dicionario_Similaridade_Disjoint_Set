/* Trabalho Final de EDB II e LP II
 * Professores: Carlos Augusto Prolo e Frederico Araujo da Silva Lopes 
 * Grupo: João Eduardo Medeiros (2013020793) e Danilo Damasceno (2013017976)
 **/

import java.util.Scanner;

public class Menu {

	public Menu() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("\nDigite a opção: (c) -- Mostrar os clusters de similaridade "
					+ "\n(t) -- Mostrar todas as palavras\n(q) -- Sair");
			String escolha = sc.next();
			if(escolha.equals("c")) {
				System.out.println("Digite a opção: (0) -- Todos \n(1) -- Adjetivos \n"
						+ "(2) -- Advérbios \n(3) -- Substantivos \n(4) -- Verbos");
				int esc = sc.nextInt();
				switch(esc) {
				case 0:
					main.uf_todos.texto();
					break;
				case 1:
					main.uf_adj.texto();
					break;
				case 2:
					main.uf_adv.texto();
					break;
				case 3:
					main.uf_subs.texto();
					break;
				case 4:
					main.uf_verbo.texto();
					break;
				}						
			}
			else if(escolha.equals("t")) {
				System.out.println("Digite a opção: (0) -- Todos \n(1) -- Adjetivos \n"
						+ "(2) -- Advérbios \n(3) -- Substantivos \n(4) -- Verbos");
				int esc = sc.nextInt();
				switch(esc) {
				case 0:
					for (int i = 0; i < main.vetor_todos.size(); i++) {
						System.out.println(main.vetor_todos.elementAt(i).getValor());
					}
					break;
				case 1:
					for (int i = 0; i < main.vetor_adj.size(); i++) {
						System.out.println(main.vetor_adj.elementAt(i).getValor());
					}
					break;
				case 2:
					for (int i = 0; i < main.vetor_adv.size(); i++) {
						System.out.println(main.vetor_adv.elementAt(i).getValor());
					}
					break;
				case 3:
					for (int i = 0; i < main.vetor_subs.size(); i++) {
						System.out.println(main.vetor_subs.elementAt(i).getValor());
					}
					break;
				case 4:
					for (int i = 0; i < main.vetor_verbo.size(); i++) {
						System.out.println(main.vetor_verbo.elementAt(i).getValor());
					}
					break;
				}	
			}
			else if(escolha.equals("q")) {
				sc.close();
				System.exit(0);
			}					
		}
	}

}
