package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeanActionEx2 {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		// 從連線池拿到連線
		Session session = factory.openSession();
		// hibernate的東西一定是在交易裡面
		session.beginTransaction();

		CompanyBean com2 = new CompanyBean(1003, "meta");

		//sava會回傳一個ID
		Serializable id = session.save(com2);
		
		System.out.println(id); //結果為1003
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
