/* Trabalho Final de EDB II e LP II
 * Professores: Carlos Augusto Prolo e Frederico Araujo da Silva Lopes 
 * Grupo: João Eduardo Medeiros (2013020793) e Danilo Damasceno (2013017976)
 **/

public class Elemento {
	private String valor;
	public Elemento pai;
	public Elemento filho;
	public int rank;

	public Elemento(String _valor) {
		valor = _valor;
	}
	
	public Elemento() {
		// TODO Auto-generated constructor stub
		valor = null;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
