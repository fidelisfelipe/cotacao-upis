package br.com.upis.cotacao.controller;

import java.util.Date;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PrincipalController {

	private final Result result;

	public PrincipalController(Result result) {
		super();
		this.result = result;
	}
	//Entrada
	@Get @Path({"","","/"})
	public void index(){}

	@Get @Path("/datas")
	public void datas(){
		result.include("date", new Date());
	}
	@Get @Path("/info")
	public void info(){
	}

}
