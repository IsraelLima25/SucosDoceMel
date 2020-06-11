package br.com.suco.doce.mel.model;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itens_notas_fiscais")
public class ItemNotaFiscal implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;

	@Column(name = "QUANTIDADE", length = 11, nullable = false)
	private Integer quantidade;
	
	@Column(name = "PRECO")
	private DecimalFormat preco;

	public ItemNotaFiscal() {
	}

}
