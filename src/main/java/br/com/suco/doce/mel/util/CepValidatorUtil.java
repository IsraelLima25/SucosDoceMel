package br.com.suco.doce.mel.util;

public class CepValidatorUtil {

	private String cep;
	private String cepFormatado;

	public CepValidatorUtil(String cep) {
		this.cep = cep;
	}

	public void removerMaskFormatter() {
		this.cepFormatado = this.cep.replaceAll("[-]", "");
	}

	/* Get and Set */

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCepFormatado() {
		return cepFormatado;
	}
}
