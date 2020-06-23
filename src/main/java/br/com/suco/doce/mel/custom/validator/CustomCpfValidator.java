package br.com.suco.doce.mel.custom.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.suco.doce.mel.util.CpfValidatorUtil;

@FacesValidator(value = "br.com.suco.doce.mel.custom.validator.CustomCpfValidator")
public class CustomCpfValidator implements Validator {

	private CpfValidatorUtil validatorCpf;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String cpf = String.valueOf(value);
		this.validatorCpf = new CpfValidatorUtil(cpf);

		if (!this.validatorCpf.isValidCpf()) {
			((UIInput) component).setValid(false);
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Cpf", "Cpf inválido"));
		}

		((UIInput) component).setValid(true);
	}

}
