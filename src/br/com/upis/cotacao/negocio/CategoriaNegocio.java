package br.com.upis.cotacao.negocio;

import br.com.caelum.vraptor.ioc.Component;
import br.com.upis.cotacao.dao.CategoriaDao;
import br.com.upis.cotacao.modelo.Categoria;

@Component
public class CategoriaNegocio {
	
	

	private static final String FALHA_AO_INSERIR_REGISTRO = "Falha ao inserir registro!";
	private static final String REGISTRO_INSERIDO_COM_SUCESSO = "Registro inserido com sucesso!";

	
	private final CategoriaDao dao;
	
	public CategoriaNegocio(CategoriaDao dao) {
		this.dao = dao;
	}
	
	public boolean existe(Categoria categoria){
		//vai na dao e pesquisa o objeto
		return false;
	}

	public String salvar(Categoria categoria){
		
		//chama a dao e retornar objeto da base
		if(categoria != null && !existe(categoria))		
		return REGISTRO_INSERIDO_COM_SUCESSO;
		
		return FALHA_AO_INSERIR_REGISTRO;
	}
}
