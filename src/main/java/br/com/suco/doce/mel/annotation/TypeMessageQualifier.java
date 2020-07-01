package br.com.suco.doce.mel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import br.com.suco.doce.mel.message.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Qualifier;

@Qualifier
@Target({ ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@RequestScoped
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeMessageQualifier {
	Message value();

}
