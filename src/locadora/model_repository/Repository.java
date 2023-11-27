package locadora.model_repository;

import locadora.model.Produto;

public interface Repository {

	public void criarProduto(Produto produto);

	public void listarProdutos();

	public void consultarPorId(int id);

	public void atualizarProduto(Produto produto);

	public void deletarProduto(int id);

}
