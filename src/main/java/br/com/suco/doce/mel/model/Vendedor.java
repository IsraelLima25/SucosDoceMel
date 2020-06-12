package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Float percentualComissao;

	@Column(name = "DATA_ADMISSAO")
	private Calendar dataAdmissao;

	@Column(name = "DE_FERIAS")
	private boolean isFerias;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;
	
	@OneToMany(mappedBy = "vendedor")
	private List<NotaFiscal> notasFiscais = new ArrayList<>();

	public Vendedor() {

	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public Float getPercentualComissao() {
		return percentualComissao;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public boolean isFerias() {
		return isFerias;
	}

	public String getBairro() {
		return bairro;
	}
	
	public List<NotaFiscal> getNotasFiscais() {
		return Collections.unmodifiableList(notasFiscais);
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPercentualComissao(Float percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setFerias(boolean isFerias) {
		this.isFerias = isFerias;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
