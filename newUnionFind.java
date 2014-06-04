/* Trabalho Final de EDB II e LP II
 * Professores: Carlos Augusto Prolo e Frederico Araujo da Silva Lopes 
 * Grupo: João Eduardo Medeiros (2013020793) e Danilo Damasceno (2013017976)
 * Baseado no algoritimo encontrado em: http://en.wikipedia.org/wiki/Disjoint-set_data_structure
 **/

public class newUnionFind implements UF {
	
	private int type;
	
	public newUnionFind(int _type) {
		type = _type;
		makeSet();
	}
	
	public void union(Elemento x, Elemento y) {
		Elemento xRoot = find(x);
		Elemento yRoot = find(y);
		
		if (xRoot == yRoot)
			return;
		if (xRoot.rank < yRoot.rank) {
			xRoot.pai = yRoot;
			yRoot.filho = xRoot;
		}
		else if(yRoot.rank < xRoot.rank) {
			yRoot.pai = xRoot;
			xRoot.filho = yRoot;
		}
		else {
			yRoot.pai = xRoot;
			xRoot.filho = yRoot;
			xRoot.rank += 1;
		}
	}
	
	public Elemento find(Elemento x) {
		if(x.filho != null)
			x = find(x.filho);
		return x;
	}
	
	public void texto() {
		main.imprimir(type);
	}
	
	public void makeSet() {
		switch(type) {
		case 0:
			for(int i = 0; i < main.vetor_todos.size(); i++) {
				main.vetor_todos.elementAt(i).pai = null;
				main.vetor_todos.elementAt(i).filho = null;
				main.vetor_todos.elementAt(i).rank = 0;
			}
			break;
		case 1:
			for(int i = 0; i < main.vetor_adj.size(); i++) {
				main.vetor_adj.elementAt(i).pai = null;
				main.vetor_adj.elementAt(i).filho = null;
				main.vetor_adj.elementAt(i).rank = 0;
			}
			break;
		case 2:
			for(int i = 0; i < main.vetor_adv.size(); i++) {
				main.vetor_adv.elementAt(i).pai = null;
				main.vetor_adv.elementAt(i).filho = null;
				main.vetor_adv.elementAt(i).rank = 0;
			}
			break;
		case 3:
			for(int i = 0; i < main.vetor_subs.size(); i++) {
				main.vetor_subs.elementAt(i).pai = null;
				main.vetor_subs.elementAt(i).filho = null;
				main.vetor_subs.elementAt(i).rank = 0;
			}
			break;
		case 4:
			for(int i = 0; i < main.vetor_verbo.size(); i++) {
				main.vetor_verbo.elementAt(i).pai = null;
				main.vetor_verbo.elementAt(i).filho = null;
				main.vetor_verbo.elementAt(i).rank = 0;
			}
			break;
		}
	}
}
