package br.com.suco.doce.mel.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.suco.doce.mel.dao.ProdutoDao;
import br.com.suco.doce.mel.message.MessageHelper;
import br.com.suco.doce.mel.model.Produto;
import br.com.suco.doce.mel.tx.Transactional;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();

	@Inject
	private ProdutoDao dao;

	@Inject
	private MessageHelper helperMessage;

	private List<Produto> produtos;

	@Transactional
	public void salvar() {

		if (produtoExiste(this.produto.getCodigoProduto())) {
			this.dao.atualiza(this.produto);
			this.produtos = this.dao.listaTodos();
			helperMessage.sendClientMessageInfo("Produto Alterado");
		} else {
			this.dao.adiciona(this.produto);
			this.produto = new Produto();
			this.produtos = this.dao.listaTodos();
			helperMessage.sendClientMessageInfo("Produto Cadastrado");
			this.produto = new Produto();
		}

	}

	private boolean produtoExiste(String codigoProduto) {
		Produto produto = this.dao.buscaPorCodigoProduto(codigoProduto);
		if (produto != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregar(Produto produto) {
		this.produto = this.dao.buscaPorCodigoProduto(produto.getCodigoProduto());
	}

	@Transactional
	public void remover(Produto produto) {
		this.dao.remove(produto);
		this.produtos = this.dao.listaTodos();
		helperMessage.sendClientMessageInfo("Produto Removido");
	}

	public void limparForm() {
		this.produto.setCodigoProduto("");
		this.produto.setNomeProduto("");
		this.produto.setEmbalagem("");
		this.produto.setTamanho("");
		this.produto.setSabor("");
		this.produto.setPrecoLista(0f);
	}

	/* Get And Set */

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = dao.listaTodos();
		}

		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
