package br.com.suco.doce.mel.custom.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.suco.doce.mel.message.MessageHelper;
import br.com.suco.doce.mel.util.CpfValidatorUtil;

//@FacesValidator(value = "br.com.suco.doce.mel.custom.validator.CustomCpfValidator")
@Named("br.com.suco.doce.mel.cpf_validation")
public class CustomCpfValidator implements Validator {

	private CpfValidatorUtil validatorCpf;
	
	@Inject
	private MessageHelper helperMessage;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String cpf = String.valueOf(value);
		this.validatorCpf = new CpfValidatorUtil(cpf);

		if (!this.validatorCpf.isValidCpf()) {
			helperMessage.sendClientMessageFatal("Cpf Inválido");
			((UIInput) component).setValid(false);
		}

		((UIInput) component).setValid(true);
	}
}
