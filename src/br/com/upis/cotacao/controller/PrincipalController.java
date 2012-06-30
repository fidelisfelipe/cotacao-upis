package br.com.upis.cotacao.controller;

import java.util.Date;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.upis.cotacao.login.UsuarioWeb;
import br.com.upis.cotacao.login.AutenticadorInterceptor.ControleUsuario;

@Resource
public class PrincipalController {

	private final Result result;
	private final UsuarioWeb usuario;

	public PrincipalController(Result result, UsuarioWeb usuario) {
		super();
		this.result = result;
		this.usuario = usuario;
	}
	//Entrada
	@Get @Path({"","","/"})
	public void index(){}
	
	@Get @Path("/logon")
	public void logonUsuario(){
		usuario.setLogin();
		result.forwardTo(this).index();
	}
	
	@Get @Path("/logout")
	public void logoutUsuario(){
		usuario.setLogout();
		result.forwardTo(this).index();
	}
	
	@ControleUsuario
	@Get @Path("/datas")
	public void datas(){
		result.include("date", new Date());
	}
	@ControleUsuario
	@Get @Path("/info")
	public void info(){
	}

}
