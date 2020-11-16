
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
	public static SessionFactory factory;
	
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}catch(Throwable ex) {
			System.err.println("Failed to create session object: "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void insertIntoDB(int id, String name, int sal, Address[] addresses) {
		Session ses = factory.openSession();
		
		Transaction t = ses.beginTransaction();
		
		Employee employee= new Employee(id, name, sal, addresses);
		
		for(Address add : addresses)
		{
			add.setEmployee(employee);
		}
		
		ses.save(employee);
		t.commit();
		ses.close();
		
	}
	
	public void displayRecords() throws HibernateException
	{
		Session ses = factory.openSession();
		
		Criteria criteria = ses.createCriteria(Employee.class);
		
		criteria.add(Restrictions.gt("sal", 4000));
		
		List employees = criteria.list();
		for(Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee emp = (Employee)iterator.next();
			System.out.println(emp.getName() + "\n" + emp.getAddress().length);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			getSessionFactory();
			Client c1 = new Client();
//			System.out.println("Main initialized");
			
			Address[] addresses = new Address[2];
			
			addresses[0] = new Address("245F", "Royal Street", "Hyderabad", 467890);
			addresses[1] = new Address("33N", "Dombivli", "Mumbai", 567890);
			
			c1.insertIntoDB(1, "Sachin Reddy", 60000, addresses);
			c1.insertIntoDB(2, "Charan Kumar", 1000000, addresses);
			c1.displayRecords();
			
		}catch(HibernateException ex) {
			System.out.println("Error is : "+ex);
		}
		
	}

}
