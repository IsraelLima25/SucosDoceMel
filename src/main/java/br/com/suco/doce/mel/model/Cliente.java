package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_de_clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "ENDERECO_1", length = 150)
	private String endereco1;

	@Column(name = "ENDERECO_2", length = 150)
	private String endereco2;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	@Column(name = "CIDADE", length = 50)
	private String cidade;

	@Column(name = "ESTADO", length = 2)
	private String estado;

	@Column(name = "CEP", length = 8)
	private String cep;
	
	@Column(name="DATA_DE_NASCIMENTO")
	private LocalDate dataNascimento;
	
	@Column(name="IDADE", length = 6)
	private Integer idade;
	
	@Column(name = "SEXO", length = 1)
	private String sexo;
	
	@Column(name = "LIMITE_DE_CREDITO")
	private DecimalFormat limiteCredito;
	
	@Column(name = "VOLUME_DE_COMPRA")
	private Float volumeCompra;
	
	@Column(name = "PRIMEIRA_COMPRA", length = 1)
	private boolean isPrimeiraCompra;

	public Cliente() {

	}

}
