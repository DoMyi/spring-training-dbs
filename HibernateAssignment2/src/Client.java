import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import oracle.net.TNSAddress.Address;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		
		List<Student> stdList = session.createQuery("from student").list();
		display(stdList);
		List<Student> clgList = session.createQuery("from college").list();
		display(clgList);
		List<Student> clgstd = session.createQuery("from college_student").list();
		display(clgstd);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			College clg = (College) iterator.next();
			System.out.println(clg.toString());
		}
	}
	
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Set<Student> vardhamanStudents = new HashSet<Student>();
			Set<Student> universalStudents = new HashSet<Student>();
			vardhamanStudents.add(new Student(101, "Sachin Reddy"));
			vardhamanStudents.add(new Student(102, "Lucifer"));
			universalStudents.add(new Student(103, "Albert Einstein"));
			universalStudents.add(new Student(104, "Boruto"));
			universalStudents.add(new Student(105, "Jett"));
			universalStudents.add(new Student(106, "Omen"));
			universalStudents.add(new Student(107, "Brimstone"));

			College vce = new College("VCE", "Vardhaman College Of Engineering", vardhamanStudents);
			College uni = new College("UNI", "College for Gifted Students", universalStudents);

			session.save(vce);
			session.save(uni);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	}
	
	

