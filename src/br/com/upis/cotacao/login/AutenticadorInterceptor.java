package br.com.upis.cotacao.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.upis.cotacao.controller.PrincipalController;

@Intercepts
public class AutenticadorInterceptor implements Interceptor{
	private final Result result;
	private final UsuarioWeb usuario;

public AutenticadorInterceptor(Result result, UsuarioWeb usuario) {
	this.result = result;
	this.usuario = usuario;
}

//apenas intercepta se o usuario nao estiver logado e o metodo for anotado
public boolean accepts(ResourceMethod metodo){
	return !this.usuario.isLogon() && metodo.containsAnnotation(Restrito.class);
}
//se interceptou, encaminha a principal com msg
public void intercept(InterceptorStack stack, ResourceMethod metodo, Object controller) throws InterceptionException {
	result.include("msg","É necessário estar logado para acessar esta funcionalidade...");
	result.forwardTo(PrincipalController.class).index();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Restrito {}


}