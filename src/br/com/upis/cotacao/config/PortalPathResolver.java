package br.com.upis.cotacao.config;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.view.DefaultPathResolver;
/**
 * @author fidelisfelipe
 * Esta classe sobrescreve as definições de direcionamento do framework
 */
@Component
public class PortalPathResolver  extends DefaultPathResolver{

	HttpServletRequest req;
	
	public PortalPathResolver(FormatResolver resolver,HttpServletRequest req) {
		super(resolver);
		this.req = req;
	}
	@Override
	protected String getPrefix() {
		return "/WEB-INF/jsp/";
	}
	@Override
	protected String getExtension() {
		return "jsp";
	}

}
