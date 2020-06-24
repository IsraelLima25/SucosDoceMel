package br.com.suco.doce.mel.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.suco.doce.mel.model.Cliente;
import br.com.suco.doce.mel.tx.Transactional;

public class ClienteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private Dao<Cliente> dao;

	@PostConstruct
	void init() {
		this.dao = new Dao<Cliente>(this.em, Cliente.class);
	}

	public void adiciona(Cliente cliente) {
		this.dao.adiciona(cliente);
	}

	public void atualiza(Cliente cliente) {
		this.dao.atualiza(cliente);
	}

	public void remove(Cliente cliente) {
		this.dao.remove(cliente);
	}

	public Cliente buscaPorCpf(String cpf) {
		return this.dao.buscaPorCpf(cpf);
	}

	public List<Cliente> listaTodos() {
		return this.dao.listaTodos();
	}

}
