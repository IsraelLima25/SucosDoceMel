package br.com.suco.doce.mel.util;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CpfValidatorUtil {

	private String cpf;
	private String cpfFormatado;
	private CPFValidator validator;
	private CPFFormatter formatter;

	public CpfValidatorUtil(String cpf) {
		this.cpf = cpf;
		validator = new CPFValidator();
		formatter = new CPFFormatter();
	}

	public void removerMaskFormatter() {
		this.cpfFormatado = formatter.unformat(this.cpf);
	}

	public boolean isValidCpf() {

		try {
			this.validator.assertValid(cpf);
			return true;
		} catch (InvalidStateException ie) {
			return false;
		}
	}

	/* Get and Set */

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpfFormatado() {
		return cpfFormatado;
	}

}
