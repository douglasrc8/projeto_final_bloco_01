package locadora.model;

public class Personagem extends Produto{

	private String personagem;

	public Personagem(int id, String nome, int tipo, double preco, String personagem) {
		super(id, nome, tipo, preco);
		this.personagem = personagem;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println(" Personagem: " + personagem);
	}
	
}
