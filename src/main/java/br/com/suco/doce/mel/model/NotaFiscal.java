package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMERO", length = 11, nullable = false, unique = true)
	private String numeroNota;

	@Column(name = "DATA_VENDA")
	private LocalDate dataVenda;

	@Column(name = "IMPOSTO", nullable = false)
	private DecimalFormat imposto;

	public NotaFiscal() {

	}

}
