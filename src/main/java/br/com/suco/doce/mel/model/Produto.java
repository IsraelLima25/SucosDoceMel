package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_de_produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_DO_PRODUTO", length = 10, nullable = false, unique = true)
	private String codigoProduto;

	@Column(name = "NOME_DO_PRODUTO", length = 50)
	private String nomeProduto;

	@Column(name = "EMBALAGEM", length = 20)
	private String embalagem;

	@Column(name = "TAMANHO", length = 10)
	private String tamanho;

	@Column(name = "SABOR", length = 20)
	private String sabor;

	@Column(name = "PRECO_DE_LISTA", nullable = false)
	private Float precoLista;

	@OneToMany(mappedBy = "key.produto")
	Set<ItemNotaFiscal> itensNotaFiscal = new HashSet<>();

	public Produto() {

	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public String getTamanho() {
		return tamanho;
	}

	public String getSabor() {
		return sabor;
	}

	public Float getPrecoLista() {
		return precoLista;
	}

	public Set<ItemNotaFiscal> getItensNotaFiscal() {
		return itensNotaFiscal;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public void setPrecoLista(Float precoLista) {
		this.precoLista = precoLista;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigoProduto == null) {
			if (other.codigoProduto != null)
				return false;
		} else if (!codigoProduto.equals(other.codigoProduto))
			return false;
		return true;
	}

}
