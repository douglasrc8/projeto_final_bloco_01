package locadora.model;

public class Produto {

	private int id;
	private String nome;
	private int tipo;
	private double preco;

	public Produto(int id, String nome, int tipo, double preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void visualizar() {
		System.out.print("Produto " + id + ", " + nome + ", tipo: " + (tipo == 1 ? "Filme" : "Personagem")
				+ ", preco: " + +preco + ",");

	}
	
}
