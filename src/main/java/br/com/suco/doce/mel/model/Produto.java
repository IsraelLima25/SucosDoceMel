package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_de_produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "CODIGO_D0_PRODUTO", length = 10, nullable = false, unique = true)
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
	private DecimalFormat precoLista;

	public Produto() {

	}

}
