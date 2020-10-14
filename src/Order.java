package My_Project.dbms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="native")
	int order_id;
	int customer_id, dealer_id;//, vehicle_id;
	String status;
	public Order()
	{
	}
	public Order(int customer_id,int dealer_id) {
		this.customer_id = customer_id;
		this.dealer_id = dealer_id;
		this.status = "PLACED";
		
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(int dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
}	
