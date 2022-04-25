package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentActionEx5 {

	public DemoDepartmentActionEx5() {
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFacotry();

		Session session = factory.getCurrentSession();

		// 拉出去
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Department dep = new Department("clothes");
			session.save(dep);
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
		}

		session.getTransaction().commit();

		session.close();

		HibernateUtils.closeSessionFactory();

	}
}
