package br.com.suco.doce.mel.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.suco.doce.mel.model.Vendedor;

public class VendedorDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private Dao<Vendedor> dao;

	@PostConstruct
	void init() {
		this.dao = new Dao<Vendedor>(this.em, Vendedor.class);
	}

	public void adiciona(Vendedor vendedor) {
		dao.adiciona(vendedor);
	}

	public void remove(Vendedor vendedor) {
		dao.remove(vendedor);
	}

	public void atualiza(Vendedor vendedor) {
		dao.atualiza(vendedor);
	}

	public List<Vendedor> listaTodos() {
		return dao.listaTodos();
	}

	public Vendedor buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public List<Vendedor> listaTodosPaginada(int firstResult, int maxResults) {
		return dao.listaTodosPaginada(firstResult, maxResults);
	}

	public Vendedor buscaPorMatricula(String matricula) {
		Vendedor instancia = this.em.find(Vendedor.class, matricula);
		return instancia;
	}

}
