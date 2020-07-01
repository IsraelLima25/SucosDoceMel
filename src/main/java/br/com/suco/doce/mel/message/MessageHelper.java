package br.com.suco.doce.mel.message;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.suco.doce.mel.annotation.TypeMessageQualifier;

public class MessageHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext context;

	@Inject
	@TypeMessageQualifier(Message.ERROR)
	private FacesMessage facesMessageError;

	@Inject
	@TypeMessageQualifier(Message.FATAL)
	private FacesMessage facesMessageFatal;

	@Inject
	@TypeMessageQualifier(Message.INFO)
	private FacesMessage facesMessageInfo;

	@Inject
	@TypeMessageQualifier(Message.WARN)
	private FacesMessage facesMessageWarn;

	public void sendClientMessageError(String msg) {
		facesMessageError.setDetail(msg);
		context.addMessage(null, facesMessageError);

	}

	public void sendClientMessageFatal(String msg) {
		facesMessageFatal.setDetail(msg);
		context.addMessage(null, facesMessageFatal);

	}

	public void sendClientMessageInfo(String msg) {
		facesMessageInfo.setDetail(msg);
		context.addMessage(null, facesMessageInfo);

	}

	public void sendClientMessageWarn(String msg) {
		facesMessageWarn.setDetail(msg);
		context.addMessage(null, facesMessageWarn);

	}

	public FacesMessage getFacesMessageFatal() {
		return facesMessageFatal;
	}

}
