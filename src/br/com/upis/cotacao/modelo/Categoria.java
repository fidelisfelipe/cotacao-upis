package br.com.upis.cotacao.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	private Integer id;
	private String nome;
	private String descricao;
	private Categoria categoriaPai;
	private List<Categoria> categoriasFilhas;
	private List<Categoria> todasCategoriasFilhasRelacionadas = new ArrayList<Categoria>();
	private List<Categoria> todasCategoriasPaiRelacionadas = new ArrayList<Categoria>();

	@Id
	@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
	@Column(name = "id_categoria", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nm_categoria", length = 255)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "ds_categoria")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_categoria_pai", referencedColumnName="id_categoria")
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	@OneToMany(mappedBy = "categoriaPai", cascade = CascadeType.PERSIST)	
	public List<Categoria> getCategoriasFilhas() {
		if (categoriasFilhas == null)
			categoriasFilhas = new ArrayList<Categoria>();
		
		return categoriasFilhas;
	}

	public void setCategoriasFilhas(List<Categoria> categoriasFilhas) {
		this.categoriasFilhas = categoriasFilhas;
	}
	
	public void addCategoriaFilha(Categoria categoriaFilha) {
		if (this.categoriasFilhas == null) {
			categoriasFilhas = new ArrayList<Categoria>();
		}
		categoriaFilha.setCategoriaPai(this);
		
		this.categoriasFilhas.add(categoriaFilha);
	}
	
	public List<Categoria> todasCategoriasFilhasRelacionadas() {
		iteraCategoriaFilhas(this);
		return todasCategoriasFilhasRelacionadas;
	}
	
	private void iteraCategoriaFilhas(Categoria c) {
		List<Categoria> subCategoryList = c.getCategoriasFilhas();
		if (!subCategoryList.isEmpty()) {
			for (Categoria category : subCategoryList) {
				iteraCategoriaFilhas(category);
			}
		}
		todasCategoriasFilhasRelacionadas.add(c);
	}
	
	public List<Categoria> todasCategoriasPaiRelacionadas(Categoria c) {
		iteraCategoryPai(c);
		return todasCategoriasPaiRelacionadas;
	}
	
	private void iteraCategoryPai(Categoria c) {
		if (c.getCategoriaPai() != null) {
			iteraCategoryPai(c.getCategoriaPai());
		}
		todasCategoriasPaiRelacionadas.add(c);
	}
	
}