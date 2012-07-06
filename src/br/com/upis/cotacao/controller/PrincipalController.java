package br.com.upis.cotacao.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;
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
	
	@Get @Path("/logout")
	public void logoutUsuario(){
		usuario.setLogout();
		result.forwardTo(this).index();
	}
	
	@Get @Path("/datas")
	public void datas(){
		result.include("date", new Date());
	}
	@Get @Path("/info")
	public void info(){
	}
	
	@Get @Path("/form")
	public void formulario(){}
	@Get @Path("/upfile")
	public void upload(){
	}
	
	@Post @Path("/upar")
	public void uploaded(UploadedFile arquivos, String sessionId){
		
		File destino = new File("c:\\upload");
		try
		{
			if(!destino.exists()){
				if(!destino.mkdir())
				System.out.println("Falha ao criar diretório...");
				
			}
			
			if(destino.exists())
				System.out.println("Diretório:"+destino+"  existe!");
				
			IOUtils.copyLarge(arquivos.getFile(), new FileOutputStream(destino+File.separator+arquivos.getFileName()));
			result.use(Results.json()).from(arquivos).serialize();  
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
		
		result.forwardTo(this).upload();
		
	}
	
	
	//Metodos de chamados de negócio
	private void realizarLogon() {
		//TODO: o negocio para realizar logon de usuario entrará aki
		usuario.setLogin();
	}
	
}
