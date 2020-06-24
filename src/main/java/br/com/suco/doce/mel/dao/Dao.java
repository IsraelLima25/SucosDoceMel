package br.com.suco.doce.mel.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class Dao<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	private EntityManager em;

	public Dao(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}

	public void adiciona(T t) {
		this.em.merge(t);
	}

	public void remove(T t) {
		this.em.remove(em.merge(t));
	}

	public void atualiza(T t) {
		this.em.merge(t);
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = this.em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}

	public T buscaPorId(Integer id) {
		T instancia = this.em.find(classe, id);
		return instancia;
	}

	public T buscaPorCpf(String cpf) {
		T instancia = this.em.find(classe, cpf);
		return instancia;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = this.em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		return lista;
	}

}
