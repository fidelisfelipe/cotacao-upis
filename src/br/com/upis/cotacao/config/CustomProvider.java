package br.com.upis.cotacao.config;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;
import br.com.caelum.vraptor.util.hibernate.HibernateTransactionInterceptor;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.com.caelum.vraptor.util.hibernate.SessionFactoryCreator;

public class CustomProvider extends SpringProvider {
	
	@Override
	protected void registerCustomComponents(ComponentRegistry registry) {
		registry.register(SessionFactoryCreator.class, SessionFactoryCreator.class); // cria uma SessionFactory
		registry.register(SessionCreator.class, SessionCreator.class); //cria Session's
	    registry.register(HibernateTransactionInterceptor.class, HibernateTransactionInterceptor.class); // open session and transaction in view
	}
}