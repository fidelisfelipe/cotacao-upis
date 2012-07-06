package br.com.upis.cotacao.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.upis.cotacao.modelo.Categoria;

@Component
public class CategoriaDao extends GenericDao<Categoria> {


	public CategoriaDao(Session sessao) {
		super(sessao);
	}

	@Override
	public void salva(Categoria categoria) {
		
			if (categoria!=null && categoria.getCategoriaPai() != null && categoria.getCategoriaPai().getId() != null) {
				categoria.setCategoriaPai(carrega(categoria.getCategoriaPai().getId()));
			} else {
				categoria.setCategoriaPai(null);
			}
		sessao.persist(categoria);
	}
	public boolean existe(Categoria categoria){
		return (sessao.createCriteria(Categoria.class).add(Restrictions.eq("nome", categoria.getNome())).uniqueResult() != null);
	}
	@Override
	public void atualiza(Categoria categoria){
		if(categoria.getCategoriaPai() != null && categoria.getCategoriaPai().getId() != null){
			categoria.setCategoriaPai(carrega(categoria.getCategoriaPai().getId()));
		}else{
			categoria.setCategoriaPai(null);
		}
		super.atualiza(categoria);		
	}
	

	@SuppressWarnings("unchecked")
	public List<Categoria> busca(String nome) {
		return sessao.createCriteria(Categoria.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
	}
	@SuppressWarnings("unchecked")
	public Categoria buscaCategoria(String nome) {
		return (Categoria) sessao.createCriteria(Categoria.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).uniqueResult();
	}
	public List<Categoria> categoriasRaiz() {
		List<Categoria> categoriasSemPai = new ArrayList<Categoria>();
		List<Categoria> todasCategorias = listarTudo();
		if (todasCategorias != null && !todasCategorias.isEmpty()) {
			for (Categoria categoria : todasCategorias) {
				if (categoria.getCategoriaPai() == null) {
					categoriasSemPai.add(categoria);
				}
			}
		}
		return categoriasSemPai;
	}

	
}