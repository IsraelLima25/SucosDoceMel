package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_de_vendedores")
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MATRICULA", length = 5, nullable = false, unique = true)
	private String matricula;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "PERCENTUAL_COMISSAO")
	private DecimalFormat percentualComissao;

	@Column(name = "DATA_ADMISSAO")
	private LocalDate dataAdmissao;

	@Column(name = "DE_FERIAS")
	private boolean isFerias;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	public Vendedor() {

	}

}
