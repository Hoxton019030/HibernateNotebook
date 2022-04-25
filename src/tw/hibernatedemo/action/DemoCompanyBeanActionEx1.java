package tw.hibernatedemo.action;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DemoCompanyBeanActionEx1 {

	public DemoCompanyBeanActionEx1() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.hbm.xml")
				.build();
		SessionFactory session = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	}

}
