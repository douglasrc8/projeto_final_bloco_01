package locadora.model;

public class Filme extends Produto{

private String genero;
	
	public Filme(int id, String nome, int tipo, double preco, String genero) {
	super(id, nome, tipo, preco);
	this.genero = genero;
}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println(" Gnero: " + genero);
	}
	
}
