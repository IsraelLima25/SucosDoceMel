package br.com.suco.doce.mel.test;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.suco.doce.mel.model.Cliente;
import br.com.suco.doce.mel.model.ItemNotaFiscal;
import br.com.suco.doce.mel.model.NotaFiscal;
import br.com.suco.doce.mel.model.Produto;
import br.com.suco.doce.mel.model.Vendedor;

public class NotaFiscalTest {

	private EntityManager em;
	private Cliente cliente;
	private Vendedor vendedor;
	private Produto produto1;
	private Produto produto2;

	@Before
	public void loadMainNotaFiscal() {

		// Instancia EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ssdm");
		this.em = emf.createEntityManager();

		// Instacia Cliente
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

		// Instancia Vendedor
		this.vendedor = new Vendedor();
		this.vendedor.setBairro("Caminho das Árvores");
		Calendar dataAdmissao = Calendar.getInstance();
		dataAdmissao.set(2000, Calendar.JULY, 20);
		this.vendedor.setDataAdmissao(dataAdmissao);
		this.vendedor.setFerias(Byte.parseByte("0"));
		this.vendedor.setMatricula("1526");
		this.vendedor.setNome("Silvanei Moreira da Costa");
		this.vendedor.setPercentualComissao(10f);

		// Instancias de produtos
		this.produto1 = new Produto();
		this.produto1.setCodigoProduto("1515");
		this.produto1.setEmbalagem("Lata");
		this.produto1.setNomeProduto("Suco de Laranja");
		this.produto1.setPrecoLista(4.50f);
		this.produto1.setSabor("Laranja");
		this.produto1.setTamanho("Médio");

		// Instancias de produtos
		this.produto2 = new Produto();
		this.produto2.setCodigoProduto("2020");
		this.produto2.setEmbalagem("Garrafa");
		this.produto2.setNomeProduto("Suco de Uva");
		this.produto2.setPrecoLista(5.05f);
		this.produto2.setSabor("Uva");
		this.produto2.setTamanho("Grande");

		try {
			this.em.getTransaction().begin();

			this.em.persist(cliente);
			this.em.persist(produto1);
			this.em.persist(produto2);
			this.em.persist(vendedor);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no before");
			this.em.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	@Test
	public void emitirNotaFiscal() {

		try {

			this.em.getTransaction().begin();

			// Buscar cliente
			Cliente clienteFind = this.em.find(Cliente.class, "04918064436");

			// Buscar vendedor
			Vendedor vendedorFind = this.em.find(Vendedor.class, "1526");

			// Buscar produto
			Produto produtoFind1 = this.em.find(Produto.class, "1515");
			Produto produtoFind2 = this.em.find(Produto.class, "2020");

			// Instanciar Nota Fiscal
			NotaFiscal notaFiscal = new NotaFiscal();
			notaFiscal.setCliente(clienteFind);
			Calendar dataVenda = Calendar.getInstance();
			dataVenda.set(2020, Calendar.JUNE, 15);
			notaFiscal.setDataVenda(dataVenda);
			notaFiscal.setImposto(20.00f);
			notaFiscal.setNumeroNota("10010");
			notaFiscal.setVendedor(vendedor);

			this.em.persist(notaFiscal);

			// Instanciar Itens Produtos

			ItemNotaFiscal item1 = new ItemNotaFiscal(produtoFind1, notaFiscal, 2, produtoFind1.getPrecoLista() * 2);
			ItemNotaFiscal item2 = new ItemNotaFiscal(produtoFind2, notaFiscal, 1, produtoFind2.getPrecoLista() * 1);

			this.em.persist(item1);
			this.em.persist(item2);

			// Associar Itens Produtos com Nota Fiscal

			notaFiscal.getItensNotaFiscal().add(item1);
			notaFiscal.getItensNotaFiscal().add(item2);

			this.em.persist(notaFiscal);

			this.em.getTransaction().commit();
			NotaFiscal findNotaFiscal = this.em.find(NotaFiscal.class, "10010");

			Assert.assertTrue(findNotaFiscal != null);

		} catch (Exception e) {
			System.out.println("Erro no corpo do teste");
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

}
