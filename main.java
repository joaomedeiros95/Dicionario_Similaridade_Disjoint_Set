/* Trabalho Final de EDB II e LP II
 * Professores: Carlos Augusto Prolo e Frederico Araujo da Silva Lopes 
 * Grupo: João Eduardo Medeiros (2013020793) e Danilo Damasceno (2013017976)
 **/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class main {

	static TreeMap<String, Integer> arvore_todos = new TreeMap<String, Integer>();
	static TreeMap<String, Integer> arvore_subs = new TreeMap<String, Integer>();
	static TreeMap<String, Integer> arvore_verbo = new TreeMap<String, Integer>();
	static TreeMap<String, Integer> arvore_adj = new TreeMap<String, Integer>();
	static TreeMap<String, Integer> arvore_adv = new TreeMap<String, Integer>();

	public static newUnionFind uf_todos;
	public static newUnionFind uf_subs;
	public static newUnionFind uf_verbo;
	public static newUnionFind uf_adj;
	public static newUnionFind uf_adv;

	public static Vector<Elemento> vetor_todos = new Vector<Elemento>();
	public static Vector<Elemento> vetor_adj = new Vector<Elemento>();
	public static Vector<Elemento> vetor_adv = new Vector<Elemento>();
	public static Vector<Elemento> vetor_subs = new Vector<Elemento>();
	public static Vector<Elemento> vetor_verbo = new Vector<Elemento>();

	public static void imprimir(int type) {
		Elemento aux;
		String enviar = "";
		switch(type) {
		case 0:
			for(int i = 0; i < vetor_todos.size(); i++) {
				if(vetor_todos.elementAt(i).filho != null && vetor_todos.elementAt(i).pai == null) {
					aux = vetor_todos.elementAt(i);
					while(aux.filho != null) {
						enviar += aux.getValor() + "::";
						aux = aux.filho;
					}
					enviar += aux.getValor() + "::";
					out(enviar);
					enviar = "";
				}
			}
			break;
		case 1:
			for(int i = 0; i < vetor_adj.size(); i++) {
				if(vetor_adj.elementAt(i).filho != null && vetor_adj.elementAt(i).pai == null) {
					aux = vetor_adj.elementAt(i);
					while(aux.filho != null) {
						enviar += aux.getValor() + "::";
						aux = aux.filho;
					}
					enviar += aux.getValor() + "::";
					out(enviar);
					enviar = "";;
				}
			}
			break;
		case 2:
			for(int i = 0; i < vetor_adv.size(); i++) {
				if(vetor_adv.elementAt(i).filho != null && vetor_adv.elementAt(i).pai == null) {
					aux = vetor_adv.elementAt(i);
					while(aux.filho != null) {
						enviar += aux.getValor() + "::";
						aux = aux.filho;
					}
					enviar += aux.getValor() + "::";
					out(enviar);
					enviar = "";
				}
			}
			break;
		case 3:
			for(int i = 0; i < vetor_subs.size(); i++) {
				if(vetor_subs.elementAt(i).filho != null && vetor_subs.elementAt(i).pai == null) {
					aux = vetor_subs.elementAt(i);
					while(aux.filho != null) {
						enviar += aux.getValor() + "::";
						aux = aux.filho;
					}
					enviar += aux.getValor() + "::";
					out(enviar);
					enviar = "";
				}
			}
			break;
		case 4:
			for(int i = 0; i < vetor_verbo.size(); i++) {
				if(vetor_verbo.elementAt(i).filho != null && vetor_verbo.elementAt(i).pai == null) {
					aux = vetor_verbo.elementAt(i);
					while(aux.filho != null) {
						enviar += aux.getValor() + "::";
						aux = aux.filho;
					}
					enviar += aux.getValor() + "::";
					out(enviar);
					enviar = "";
				}
			}
			break;
		}
	}
	private static void out(String enviar) {
		if(!enviar.isEmpty()) enviar = enviar.substring(0, enviar.length() - 2);
		if(!enviar.isEmpty()) {
			System.out.println(enviar);
		}
	}

	public static void main(String[] args) {
		System.out.println("Processando... Aguarde");
		try {
			Scanner arquivo = new Scanner(new FileReader("arvore.txt"));
			String linha = null;
			while(arquivo.hasNextLine()) {
				linha = arquivo.nextLine();

				linha = linha.replaceAll("\\s+", " ");
				linha = linha.replaceAll("\\(", "");

				String[] nodos = linha.split(" ");

				for(int i = 0; i < nodos.length; i++) {
					if (nodos[i].equals("NN") || nodos[i].equals("NNS")) {
						if(nodos[i+1].contains(")")) {
							nodos[i+1] = nodos[i+1].replaceAll("\\)", "");
							arvore_subs.put(nodos[i+1], 0);
							arvore_todos.put(nodos[i+1], 0);
							i++;
						}
					}
					else if (nodos[i].startsWith("V")) {
						if(nodos[i+1].contains(")")) {
							nodos[i+1] = nodos[i+1].replaceAll("\\)", "");
							arvore_verbo.put(nodos[i+1], 0);
							arvore_todos.put(nodos[i+1], 0);
							i++;
						}
					}
					else if (nodos[i].equals("JJ") || nodos[i].equals("JJR") || nodos[i].equals("JJS")) {
						if(nodos[i+1].contains(")")) {
							nodos[i+1] = nodos[i+1].replaceAll("\\)", "");
							arvore_adj.put(nodos[i+1], 0);
							arvore_todos.put(nodos[i+1], 0);
							i++;
						}
					}
					else if (nodos[i].equals("RB") || nodos[i].equals("RBR") || nodos[i].equals("RBS")) { 
						if(nodos[i+1].contains(")")) {
							nodos[i+1] = nodos[i+1].replaceAll("\\)", "");
							arvore_adv.put(nodos[i+1], 0);
							arvore_todos.put(nodos[i+1], 0);
							i++;
						}
					}
				}
			}

			arquivo.close();

			Elemento element;

			for(String key: arvore_todos.keySet()){
				element = new Elemento(key);
				vetor_todos.add(element);
			}

			for(String key: arvore_adj.keySet()){
				element = new Elemento(key);
				vetor_adj.add(element);
			}

			for(String key: arvore_adv.keySet()){
				element = new Elemento(key);
				vetor_adv.add(element);
			}

			for(String key: arvore_subs.keySet()){
				element = new Elemento(key);
				vetor_subs.add(element);
			}

			for(String key: arvore_verbo.keySet()){
				element = new Elemento(key);
				vetor_verbo.add(element);
			}

			uf_todos = new newUnionFind(0);
			uf_adj = new newUnionFind(1);
			uf_adv = new newUnionFind(2);
			uf_subs = new newUnionFind(3);
			uf_verbo = new newUnionFind(4);

			Similaridade.calculo(vetor_todos, 0);
			Similaridade.calculo(vetor_adj, 1);
			Similaridade.calculo(vetor_adv, 2);
			Similaridade.calculo(vetor_subs, 3);
			Similaridade.calculo(vetor_verbo, 4);
			
			Menu menu = new Menu();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (@SuppressWarnings("hiding") IOException e) {
			System.out.println(e);
		}
	}
}
