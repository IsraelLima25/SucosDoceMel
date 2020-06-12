package br.com.suco.doce.mel.test;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.suco.doce.mel.model.Cliente;

public class ClienteTest {

	private EntityManager em;
	private Cliente cliente;

	@Before
	public void loadMainCliente() {

		// Instancia EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ssdm");
		this.em = emf.createEntityManager();

		// Instancia Cliente para Test
		this.cliente = new Cliente();
		this.cliente.setCpf("04918064436");
		this.cliente.setBairro("Pirajá");
		this.cliente.setCep("41290221");
		this.cliente.setCidade("Salvador");
		Calendar data = Calendar.getInstance();
		data.set(1991, Calendar.MARCH, 31);
		this.cliente.setDataNascimento(data);
		this.cliente.setEndereco1("Primeira Travessa Ferreira");
		this.cliente.setEndereco2(null);
		this.cliente.setEstado("BA");
		this.cliente.setIdade(29);
		this.cliente.setLimiteCredito(800.00f);
		this.cliente.setNome("Israel Santos Lima Filho");
		this.cliente.setPrimeiraCompra(Byte.parseByte("1"));
		this.cliente.setSexo("M");
		this.cliente.setVolumeCompra(0f);
	}

	@Test
	public void cadastrarCliente() {

		em.getTransaction().begin();

		int quantidadeRegistroTabelaClienteAntesInsert = em.createQuery("select cliente from Cliente cliente")
				.getResultList().size();

		em.persist(this.cliente);

		int quantidadeRegistroTabelaClienteDepoisInsert = em.createQuery("select cliente from Cliente cliente")
				.getResultList().size();

		em.getTransaction().commit();

		Assert.assertTrue(quantidadeRegistroTabelaClienteAntesInsert < quantidadeRegistroTabelaClienteDepoisInsert);
	}

	@Test
	public void removerCliente() {

		// Transaction persist
		em.getTransaction().begin();
		em.persist(this.cliente);
		em.getTransaction().commit();

		// Transaction remove
		em.getTransaction().begin();
		em.remove(this.cliente);
		em.getTransaction().commit();

		Cliente cliente = em.find(Cliente.class, this.cliente.getCpf());

		Assert.assertTrue(cliente == null);

	}

	@After
	public void cleanTableClienteTest() {
		try {
			em.getTransaction().begin();
			this.em.remove(this.cliente);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();

		}

	}

}
