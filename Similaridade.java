/* Trabalho Final de EDB II e LP II
 * Professores: Carlos Augusto Prolo e Frederico Araujo da Silva Lopes 
 * Grupo: João Eduardo Medeiros (2013020793) e Danilo Damasceno (2013017976)
 **/

import java.util.Vector;

public class Similaridade {
	
	public static void calculo (Vector<Elemento> vector, int type) {
		int numofdif = 0;
		int numofpass = 0;
		for(int i = 0; i < vector.size(); i++) {
			for(int j = i + 1; j < vector.size(); j++, numofdif = 0, numofpass = 0) {
				if(vector.elementAt(i).getValor().length() == vector.elementAt(j).getValor().length()) {
					for(int index = 0; index < vector.elementAt(i).getValor().length(); index++) {
						if(vector.elementAt(i).getValor().charAt(index) != vector.elementAt(j).getValor().charAt(index)) {							
							numofdif++;
						}
						if (numofdif > 1)
							break;
					}
					if(numofdif <= 1) {
						switch(type) {
						case 0:
							main.uf_todos.union(main.vetor_todos.elementAt(i), main.vetor_todos.elementAt(j));
							break;
						case 1:
							main.uf_adj.union(main.vetor_adj.elementAt(i), main.vetor_adj.elementAt(j));
							break;
						case 2:
							main.uf_adv.union(main.vetor_adv.elementAt(i), main.vetor_adv.elementAt(j));
							break;
						case 3:
							main.uf_subs.union(main.vetor_subs.elementAt(i), main.vetor_subs.elementAt(j));
							break;
						case 4:
							main.uf_verbo.union(main.vetor_verbo.elementAt(i), main.vetor_verbo.elementAt(j));
							break;
						}
					}
				}
				else if(vector.elementAt(i).getValor().length() - vector.elementAt(j).getValor().length() == 1 ||
						vector.elementAt(i).getValor().length() - vector.elementAt(j).getValor().length() == -1) {
					if(vector.elementAt(i).getValor().length() < vector.elementAt(j).getValor().length()) {
						for(int indexi = 0, indexj = 0; indexi < vector.elementAt(i).getValor().length() && indexj < vector.elementAt(j).getValor().length(); indexi++, indexj++) {
							if(vector.elementAt(j).getValor().charAt(indexj) !=
									(vector.elementAt(i).getValor().charAt(indexi))) {
								if(indexj + 1 < vector.elementAt(j).getValor().length())
									indexj++;
								if(vector.elementAt(j).getValor().charAt(indexj) ==
										(vector.elementAt(i).getValor().charAt(indexi)))
									numofpass++;
								else
									numofdif++;
							}
							if(numofpass > 1) {
								break;
							}
							if(numofdif > 0) {
								break;
							}
						}
					}
					else {
						for(int indexi = 0, indexj = 0; indexj < vector.elementAt(j).getValor().length() && indexi < vector.elementAt(i).getValor().length(); indexj++, indexi++) {
							if(vector.elementAt(i).getValor().charAt(indexi) !=
									(vector.elementAt(j).getValor().charAt(indexj))) {
								if(indexi + 1 < vector.elementAt(i).getValor().length())
									indexi++;
								if(vector.elementAt(i).getValor().charAt(indexi) ==
										(vector.elementAt(j).getValor().charAt(indexj)))
									numofpass++;
								else
									numofdif++;
							}
							if(numofpass > 1) {
								break;
							}
							if(numofdif > 0) {
								break;
							}
						}
					}
					if(numofpass <= 1 && numofdif == 0)  {
						switch(type) {
						case 0:
							main.uf_todos.union(main.vetor_todos.elementAt(i), main.vetor_todos.elementAt(j));
							break;
						case 1:
							main.uf_adj.union(main.vetor_adj.elementAt(i), main.vetor_adj.elementAt(j));
							break;
						case 2:
							main.uf_adv.union(main.vetor_adv.elementAt(i), main.vetor_adv.elementAt(j));
							break;
						case 3:
							main.uf_subs.union(main.vetor_subs.elementAt(i), main.vetor_subs.elementAt(j));
							break;
						case 4:
							main.uf_verbo.union(main.vetor_verbo.elementAt(i), main.vetor_verbo.elementAt(j));
							break;
						}
					}
				}
			}
		}
	}

}
