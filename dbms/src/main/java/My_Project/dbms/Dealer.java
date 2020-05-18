package My_Project.dbms;

import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.CascadeType;
//import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
@Entity
@Table(name="dealer")
public class Dealer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="native")
	int dealer_id;
	String name;
//	@ManyToMany(targetEntity=Customer.class,cascade=CascadeType.ALL)
//	@JoinTable(name="categories_item",joinColumns=@JoinColumn(name="cat_id_fk",referencedColumnName="catid"),inverseJoinColumns=@JoinColumn(name="item_id_fk",referencedColumnName="itemid"))
//	private Set customers;
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Order.class, cascade=CascadeType.ALL)
	@JoinColumn(name="dealer_id",referencedColumnName="dealer_id")
	private Set orders;
	
	
	
	public Dealer() {
		
	}
	
	public Dealer(String name) {
		super();
		this.name = name;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDealer_id() {
		return dealer_id;
	}
	public void setChildren(Set ord) {
		this.orders = ord;
	}
	public void setOrder(Order ord) {
		this.orders.add(ord);
	}

}
