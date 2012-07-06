package br.com.upis.cotacao.negocio;

import br.com.caelum.vraptor.ioc.Component;
import br.com.upis.cotacao.dao.MarcaDao;
import br.com.upis.cotacao.modelo.Marca;

@Component
public class MarcaNegocio {
	private static final String FALHA_AO_INSERIR_REGISTRO = "Falha ao inserir registro";
	private static final String REGISTRO_INSERIDO_COM_SUCESSO = "Registro inserido com sucesso!";

	private final MarcaDao dao;

	public MarcaNegocio(MarcaDao dao) {
		this.dao = dao;

	}

	public boolean existe(Marca marca) {
		// vai na dao e pesquisa objeto
		return false;
	}

	public String salvar(Marca marca) {
		// chama a dao e retorna objeto da base
		if (marca != null && !existe(marca))
			return REGISTRO_INSERIDO_COM_SUCESSO;

		return FALHA_AO_INSERIR_REGISTRO;
	}

}
