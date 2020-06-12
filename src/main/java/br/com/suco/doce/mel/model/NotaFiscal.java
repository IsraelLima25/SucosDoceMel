package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMERO", length = 11, nullable = false, unique = true)
	private String numeroNota;

	@Column(name = "DATA_VENDA")
	@Temporal(TemporalType.DATE)
	private Calendar dataVenda;

	@Column(name = "IMPOSTO", nullable = false)
	private Float imposto;

	@ManyToOne
	@JoinColumn(name = "CPF")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "MATRICULA")
	private Vendedor vendedor;

	@OneToMany(mappedBy = "key.notaFiscal")
	Set<ItemNotaFiscal> itensNotaFiscal = new HashSet<>();

	public NotaFiscal() {

	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Float getImposto() {
		return imposto;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Set<ItemNotaFiscal> getItensNotaFiscal() {
		return this.itensNotaFiscal;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setImposto(Float imposto) {
		this.imposto = imposto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setItensNotaFiscal(Set<ItemNotaFiscal> itensNotaFiscal) {
		this.itensNotaFiscal = itensNotaFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroNota == null) ? 0 : numeroNota.hashCode());
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
		NotaFiscal other = (NotaFiscal) obj;
		if (numeroNota == null) {
			if (other.numeroNota != null)
				return false;
		} else if (!numeroNota.equals(other.numeroNota))
			return false;
		return true;
	}

}
