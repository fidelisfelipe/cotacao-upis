package br.com.upis.cotacao.login;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {
	//TODO: Inserir log4j
	private boolean logon;

	public boolean isLogon() {
		
		return logon;
	}

	public void setLogin() {
		this.logon = true;
	}
	
	public void setLogout() {
		this.logon = false;
	}
	
}
