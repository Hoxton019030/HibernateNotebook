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

public class DemoDepartmentActionEx3 {

	public DemoDepartmentActionEx3() {
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFacotry();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Department dep3 = new Department("Sales");
			
			session.save(dep3);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("someting wrong");
			session.getTransaction().rollback();
		} finally {
			HibernateUtils.closeSessionFactory();
		}


		session.getTransaction().commit();

		session.close();

		HibernateUtils.closeSessionFactory();

	}
}
