package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public enum SingletonSessionFactory {
	Factory;
	private final Configuration cfg;
	private final SessionFactory sessionFactory;
	private final StandardServiceRegistryBuilder srb;
	SingletonSessionFactory(){
		cfg = new Configuration().configure();
		srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		StandardServiceRegistry sr = srb.build();
		sessionFactory = cfg.buildSessionFactory(sr); 
	}
	public static Session getSession(){
		Session session = Factory.sessionFactory.openSession();
		return session;
	}
}
