package br.com.upis.cotacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.upis.cotacao.modelo.Categoria;
import br.com.upis.cotacao.negocio.CategoriaNegocio;

@Resource
@Path("/categoria")
public class CategoriaController {
	private final String contexto = "categoria";

	private final Result result;
	private final CategoriaNegocio negocio;

	public CategoriaController(Result result, CategoriaNegocio negocio) {
		this.result = result;
		this.negocio = negocio;
	}
	
	public void form(){
		result.include("contexto",contexto);
	}
	
	@Get @Path("/novo")
	public void novo(){
		//faz algo pra novo
		result.forwardTo(this).form();
	}
	
	@Post @Path("/novo")
	public void novo(Categoria categoria){
		
		String msg = negocio.salvar(categoria);
		
		result.include("msg",msg);
		
		result.include("categoria",categoria);
		result.forwardTo(this).form();
	}
	
	
}
