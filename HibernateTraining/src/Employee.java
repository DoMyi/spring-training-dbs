import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String name;
	private int sal;
	
	@OrderColumn
	@OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
	private Address[] addresses;
	
	
	
	
	public Employee() {
	}


	public Employee(int id, String name, int sal, Address[] addresses) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.addresses = addresses;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address[] getAddress() {
		return addresses;
	}
	public void setAddress(Address[] address) {
		this.addresses = address;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
}
