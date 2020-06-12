package br.com.suco.doce.mel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "itens_notas_fiscais")
public class ItemNotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemNotaFiscalkey key = new ItemNotaFiscalkey();

	@Column(name = "QUANTIDADE", length = 11, nullable = false)
	private Integer quantidade;	

	@Column(name = "PRECO")
	private Float preco;

	public ItemNotaFiscal() {
	}

	public ItemNotaFiscal(NotaFiscal notaFiscal, Integer quantidade, Float preco) {

		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public ItemNotaFiscalkey getKey() {
		return key;
	}

}
