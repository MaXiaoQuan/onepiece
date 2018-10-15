package priv.mq.onePiece.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import priv.mq.onePiece.entities.User;

public class HibernateTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		SessionFactory sessionFactory = null;
		
		Configuration configuration = new Configuration().configure();
		configuration.addClass(User.class);
		
		ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hql = "FROM User u where u.phone = 18860016827";
		
		Query<User> query = session.createQuery(hql);
		
		List<User> list = query.list();
		System.out.println(Arrays.toString(list.toArray()));
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
	
	@Test
	public void testChar() {
		String str = "so��������";
		char c[] = str.toCharArray();
		for(int i = 0; i < c.length; i++){
			System.out.println(c[i]);
		}
	}
	
	@Test
	public void testDataSource(){
		
		System.out.println(sessionFactory.getClass());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testLogin(){
		Session session = getSession();
		String hql = "FROM User u where u.phone = 18860016827";
		Query<User> query = session.createQuery(hql);
		List<User> resultList = query.list();
		System.out.println(resultList.size());
	}
	
}
