package br.com.suco.doce.mel.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.suco.doce.mel.model.Cliente;
import br.com.suco.doce.mel.model.Produto;
import br.com.suco.doce.mel.model.Vendedor;

public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;
	Dao<Produto> dao;

	@PostConstruct
	void init() {
		this.dao = new Dao<Produto>(em, Produto.class);
	}

	public void adiciona(Produto produto) {
		dao.adiciona(produto);
	}

	public void remove(Produto produto) {
		dao.remove(produto);
	}

	public void atualiza(Produto produto) {
		dao.atualiza(produto);
	}

	public List<Produto> listaTodos() {
		return dao.listaTodos();
	}

	public Produto buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public List<Produto> listaTodosPaginada(int firstResult, int maxResults) {
		return dao.listaTodosPaginada(firstResult, maxResults);
	}

	public Produto buscaPorCodigoProduto(String codigoProduto) {
			Produto instancia = this.em.find(Produto.class, codigoProduto);
			return instancia;
	}

}
