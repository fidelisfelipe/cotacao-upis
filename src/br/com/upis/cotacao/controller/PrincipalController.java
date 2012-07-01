package br.com.upis.cotacao.controller;

import java.util.Date;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.upis.cotacao.login.AutenticadorInterceptor.ControleUsuario;
import br.com.upis.cotacao.login.UsuarioWeb;

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
	@Get @Path({"","/"})
	public void index(){}
	
	@Get @Path("/sign-in")
	public void logon(){}
	

	@Get @Path("/logon")
	public void logonUsuario(){
		realizarLogon();
		result.forwardTo(this).index();
	}
	
	@ControleUsuario
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
	
	@ControleUsuario
	@Get @Path("/form")
	public void formulario(){}
	
	
	//Metodos de chamados de negócio
	private void realizarLogon() {
		//TODO: o negocio para realizar logon de usuario entrará aki
		usuario.setLogin();
	}
	
}
