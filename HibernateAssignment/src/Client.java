import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getSessionFactory();
			Client c = new Client();
			
			c.insertRecordInDatabase(1, "John Doe", 52, "12/12/2020", 101);
			c.insertRecordInDatabase(2, "Naruto", 21, "12/12/2020", 101);
			c.insertRecordInDatabase(3, "Goku", 108, "12/12/2020", 101);
			c.insertRecordInDatabase(4, "Bu", 152, "12/12/2020", 101);
			c.insertRecordInDatabase(5, "Beerus Sama", 10000, "12/12/2020", 101);
			
			c.displayRecordsCriteria();
			
		} catch(HibernateException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	public void insertRecordInDatabase(int id, String passangerName, int age, String journeyDate, int ticketNo) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		TrainReservation tr1 = new TrainReservation(id, passangerName, age, journeyDate, ticketNo);
		session.save(tr1);
		tx.commit();
		session.close();
	}
	
	public void displayRecordsCriteria() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(TrainReservation.class);
		
		int minAge = 25;
		int maxAge = 65;
		cr.add(Restrictions.gt("age", minAge));
		cr.add(Restrictions.lt("age", maxAge));
		List employees = cr.list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
		}
		
	}
	
}