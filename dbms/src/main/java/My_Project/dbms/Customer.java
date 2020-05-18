package My_Project.dbms;

//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.ManyToMany;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="native")
	private int customer_id;
	private String name, email;

	public Customer() {
		
	}
	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomer_id() {
		return customer_id;
	}

	
}
