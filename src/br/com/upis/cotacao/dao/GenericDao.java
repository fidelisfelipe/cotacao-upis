package br.com.upis.cotacao.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public class GenericDao<T> {

	protected Session sessao;
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDao(Session sessao) {
		this.sessao = sessao;
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salva(T t) {
		sessao.persist(t);
	}
	
	public void salvaOrUpdate(T t) {
		sessao.saveOrUpdate(t);
	}
	public void salvaOrUpdateCommit(T t) {
		sessao.saveOrUpdate(t);
		sessao.beginTransaction().commit();
	}
	
	public void atualiza(T t) {
		sessao.merge(t);
	}

	public void exclui(T t) {
		sessao.delete(t);
	}
	public void excluiCommit(T t) {
		sessao.delete(t);
		sessao.getTransaction().commit();
	}
	
	public void recarrega(T t) {
		sessao.refresh(t);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listarTudo() {
		return this.sessao.createCriteria(persistentClass).list();
	}
	@SuppressWarnings("unchecked")
	public List<T> listarTudoLimite(int qnt) {
		return this.sessao.createCriteria(persistentClass).setMaxResults(qnt).list();
	}
	
	@SuppressWarnings("unchecked")
	public T carrega(Integer id) {
		return (T) this.sessao.load(persistentClass, id);
	}
	/**Total de registros
	 * @return
	 */
	public Integer totalRegistros(){
		return (Integer)this.sessao.createCriteria(persistentClass).setProjection(Projections.rowCount()).uniqueResult();
	}
	/**Intervalo Para Paginação
	 * @param qntRegistros
	 * @param pagina
	 * @return
	 */
	public List<T> carregarIntervalo(int porPagina,int paginaAtual,int total){
		int primeiroRegistro = paginaAtual*porPagina;
		return this.sessao.createCriteria(persistentClass).setFirstResult(primeiroRegistro).setMaxResults(porPagina).list();
	}
}