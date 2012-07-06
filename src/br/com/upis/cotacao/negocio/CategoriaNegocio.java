package br.com.upis.cotacao.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.upis.cotacao.dao.CategoriaDao;
import br.com.upis.cotacao.modelo.Categoria;

@Component
public class CategoriaNegocio {

	private static final String FALHA_AO_INSERIR_REGISTRO = "Falha ao inserir registro!";
	private static final String REGISTRO_INSERIDO_COM_SUCESSO = "Registro inserido com sucesso!";
	private static final String FALHA_AO_REMOVER_CATEGORIA = "Não foi possivel remover a categoria, provavelmente ela esteja associada a outras filhas.";
	private static final java.lang.String JA_EXISTE = null;
	private static final java.lang.String CADASTRADO_COM_SUCESSO = null;
	private static final java.lang.String SUCESSO_AO_ATUALIZAR = null;
	private static final java.lang.String SUCESSO_AO_REMOVER = null;
	private static final java.lang.String FALHA_AO_ATUALIZAR = null;
	private static final java.lang.String FALHA_AO_REMOVER = null;
	
	private final CategoriaDao dao;
	
	public CategoriaNegocio(CategoriaDao dao) {
		this.dao = dao;
	}
	
	public String adiciona(Categoria categoria) {
		// rn
		if (dao.existe(categoria)) {
			return JA_EXISTE;
		}
		dao.salva(categoria);
		return REGISTRO_INSERIDO_COM_SUCESSO;
	}

	public List<Categoria> listarTudo() {
		List<Categoria> produtoList = dao.listarTudo();
		return produtoList;
	}

	public List<Categoria> buscar(String criterio) {
		List<Categoria> resultado = dao.busca(criterio);
		return resultado;
	}


	public Categoria carrega(Integer id) {
		Categoria existe = dao.carrega(id);
		
		if(existe != null)
			return existe;
		
			return null;
			
	}

	public String altera(Categoria produto) {
		if(dao.existe(produto)){
			dao.atualiza(produto);
			return SUCESSO_AO_ATUALIZAR;
		}
		
		return FALHA_AO_ATUALIZAR;
	}
	
	public String remove(Integer id) {
		Categoria categoria = dao.carrega(id);
		List<Categoria> todas = listarTudo();
		List<Categoria> filhas = new ArrayList<Categoria>();
		
		for (Categoria c : todas) {
			if(c.getCategoriaPai() != null && c.getCategoriaPai() == categoria)
				filhas.add(c);
		}
		
		if(filhas.isEmpty()){
			dao.exclui(categoria);
			return SUCESSO_AO_REMOVER;
		}else{
			return FALHA_AO_REMOVER_CATEGORIA;
		}
	}
	
	public void ajustaListaDeAssociacao(List<Categoria> categoriaList,
			Categoria categoria) {
		//nao deixa associar a ela mesma
		if(categoria != null){
		    categoriaList.remove(categoria);
		
		//e remove a categoria pai da combo tbm
		if(categoria.getCategoriaPai() != null && categoria.getCategoriaPai().getId() != null)
			categoriaList.remove(categoria.getCategoriaPai());	
		
		}
	}
}
