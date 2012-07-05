package br.com.upis.cotacao.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.upis.cotacao.modelo.Marca;
import br.com.upis.cotacao.negocio.MarcaNegocio;

@Resource
@Path("/marca")
public class MarcaController {
	private final String contexto = "marca";

	private final Result result;
	private final MarcaNegocio negocio;

	public MarcaController(Result result, MarcaNegocio negocio) {
		this.result = result;
		this.negocio = negocio;
	}

	public void form() {
		result.include("contexto", contexto);
	}

	@Get
	@Path("/novo")
	public void novo() {
		// faz algo pra novo
		result.forwardTo(this).form();
	}

	@Post
	@Path("/novo")
	public void novo(Marca marca) {

		String msg = negocio.salvar(marca);
		
		result.include("msg",msg);

		result.include("categoria", marca);
		result.forwardTo(this).form();
	}

}
