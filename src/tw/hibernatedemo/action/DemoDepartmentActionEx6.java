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

public class DemoDepartmentActionEx6 {

	public DemoDepartmentActionEx6() {
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFacotry();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			//第一個參數代表要讀取之資料物件的類別，第二個參數表示主鍵值
			Department department = session.get(Department.class, 2
			System.out.println(department.getDepid());
			System.out.println(department.getDeptname());
			
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			
		} finally {
 		}

		session.getTransaction().commit();

		session.close();

		HibernateUtils.closeSessionFactory();

	}
}
