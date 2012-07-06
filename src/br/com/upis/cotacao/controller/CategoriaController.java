package br.com.upis.cotacao.controller;

import java.util.List;

import org.hibernate.HibernateException;

import br.com.caelum.vraptor.Delete;
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

	public void form(String nameDivShow){		
		result.include("contexto", this.contexto);
		result.include("titulo", this.contexto);
		result.include("nameDivShow",nameDivShow);
	}
	
	private void listarRegistros(){
		List<Categoria> categoriaList = negocio.listarTudo();
		result.include("categoriaList", categoriaList);
	}
	
	@Get
	@Path({"/",""})
	public void lista() {
		List<Categoria> categoriaList = negocio.listarTudo();
		result.include("categoriaList", categoriaList);
		result.include("objectList", categoriaList);
		result.include("categoriasParaAssociacaoList", categoriaList);
		result.forwardTo(this).form("lista");
	}

	@Get
	@Path("/novo")
	public void novo() {
		List<Categoria> categoriaList = negocio.listarTudo();
		Categoria categoria = recuperaObjetoDoResult();
		
		negocio.ajustaListaDeAssociacao(categoriaList, categoria);
		listarRegistros();
		result.include("categoriasParaAssociacaoList", categoriaList);
		result.forwardTo(this).form("novo");
	}

	@Get
	@Path("/{id}")
	public void edita(Integer id) {
		result.on(HibernateException.class).forwardTo(this).lista();
		
		Categoria categoria = negocio.carrega(id);
		result.include("categoria", categoria);
		
		result.forwardTo(this).novo();
	}

	@Post
	@Path({"/",""})
	public void adiciona(final Categoria categoria) {
		result.on(HibernateException.class).forwardTo(this).novo();
		
		String msg = negocio.adiciona(categoria);
		
		defineMsg(msg);
	
		result.include("categoria", categoria);
		result.forwardTo(this).novo();
	}
	
	@Post
	@Path("/{categoria.id}")
	public void altera(Categoria categoria) {
		result.on(HibernateException.class).forwardTo(this).lista();
		String msg = negocio.altera(categoria);
		
		result.include("msg", msg);
		result.include("categoria", categoria);
		result.forwardTo(this).novo();
	}
	
	@Delete
	@Path("/{id}")
	public void remove(Integer id) {
		result.on(HibernateException.class).forwardTo(this).lista();
		
		String msg = negocio.remove(id);
		
		result.include("msg",msg);
		result.forwardTo(this).lista();
	}
	
	@Post @Path("/buscar")
	public void busca(String criterio) {
		List<Categoria> categoriaList = negocio.buscar(criterio);
		
		result.include("contexto", this.contexto);
		result.include("criterio", "Resultado da busca por <b>\""+criterio+"\"</b><br />");
		
		result.include("categoriaList", categoriaList);
		result.include("objectList", categoriaList);
		
		result.forwardTo(this).form("lista");
	}

	private Categoria recuperaObjetoDoResult() {
		Categoria categoria = null;
		if(result.included().containsKey("categoria"))
			categoria = (Categoria)result.included().get("categoria");

		return categoria;
	}
	
	private void defineMsg(String msg) {
		result.include("msg",msg);
		if(msg != null)
		result.include("nameDivShow","DivErro");
	}
}
