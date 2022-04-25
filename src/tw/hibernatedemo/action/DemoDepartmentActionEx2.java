package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx2 {

	public DemoDepartmentActionEx2() {
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFacotry();

		Session session = factory.openSession();

		session.beginTransaction();

		Department d2 = new Department("RD");

		session.save(d2);

		session.getTransaction().commit();

		session.close();

		HibernateUtils.closeSessionFactory();

	}
}
