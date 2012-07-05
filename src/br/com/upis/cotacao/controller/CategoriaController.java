package br.com.upis.cotacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.upis.cotacao.modelo.Categoria;

@Resource
@Path("/categoria")
public class CategoriaController {
	private final String contexto = "categoria";

	private final Result result;

	public CategoriaController(Result result) {
		this.result = result;
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
		
		//salvar o objeto na base
		
		//recuperar objeto salvo
		
		//mensagem de ok
		result.include("msg","Registro inserido com sucesso!");
		
		result.include("categoria",categoria);
		result.forwardTo(this).form();
	}
	
	
}
