package br.com.suco.doce.mel.message;

import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;

import br.com.suco.doce.mel.annotation.TypeMessageQualifier;

public class MessageFactory {

	@Produces
	@TypeMessageQualifier(Message.ERROR)
	public FacesMessage msgError() {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "");
	}

	@Produces
	@TypeMessageQualifier(Message.FATAL)
	public FacesMessage msgFatal() {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, "", "");
	}

	@Produces
	@TypeMessageQualifier(Message.INFO)
	public FacesMessage msgInfo() {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, "", "");
	}

	@Produces
	@TypeMessageQualifier(Message.WARN)
	public FacesMessage msgWarn() {
		return new FacesMessage(FacesMessage.SEVERITY_WARN, "", "");
	}
}
