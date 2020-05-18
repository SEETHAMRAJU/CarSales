package My_Project.dbms;
import java.util.Properties;

import javax.*;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*; 

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Features {
	
	private Session session;
	private List<Integer> custom = new ArrayList<Integer>();
	private List<Integer> orders = new ArrayList<Integer>();
	
	public Features(Session session)
	{
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	
	public void createCustomer(String name,String email) {
		Customer cus = new Customer(name.toUpperCase(),email);
		
		Transaction tx = session.beginTransaction();
		String hql = "FROM Customer AS E WHERE E.name = \'"+cus.getName()+"\' AND E.email = \'"+cus.getEmail()+"\'";
		Query query = session.createQuery(hql);
		List<Customer> results = query.list();
		if(results.size()!=0) {
			System.out.println("Duplicate Customer Information");
		}
		else {
			session.save(cus);
			session.persist(cus);
			System.out.println("YOUR ID : "+cus.getCustomer_id());
			tx.commit();
		}
	}
	
	
	
	public int createDealer(String name) {
		Dealer dealer = new Dealer(name);
		Transaction tx = session.beginTransaction();
		session.save(dealer);
		session.persist(dealer);
		tx.commit();
		return dealer.getDealer_id();
	}	

	public int placeOrder(int cust_id, int dealer_id) {
		Order ord= new Order(cust_id,dealer_id);
		Transaction tx = session.beginTransaction();
		session.save(ord);
		session.persist(ord);
		tx.commit();
		
		orders.add(ord.getOrder_id());
		System.out.println("YOUR ORDER ID : "+ord.getOrder_id());
		
		return ord.getOrder_id();
	}
	
	public int getCustomerID(String name, String email)
	{
		Transaction tx = session.beginTransaction();
		String hql = "FROM Customer AS E WHERE E.name = \'"+name.toUpperCase()+"\' AND E.email = \'"+email+"\'";
		Query query = session.createQuery(hql);
		List<Customer> results = query.list();
		tx.commit();
		if(results.size()!=0)
			return results.get(0).getCustomer_id();
		else
			return -1;
	}
	
	public String getOrderStatus(int order_id) {
		int i=0;
		Transaction tx1 = session.beginTransaction();
		String hql = "FROM Order AS E WHERE E.order_id = \'"+order_id+"\'";
		Query query = session.createQuery(hql);
		List<Order> orders = query.list();
		tx1.commit();
		if(orders.size()!=0)
			return orders.get(0).getStatus();
		else
			return "ORDER DOESN'T EXIST";
	}
	

	
	
	public void produceVehicle() {
		int i = 0;
		Transaction tx1 = session.beginTransaction();
		String hql = "FROM Order AS E WHERE E.status = \'"+"PLACED"+"\'";
		Query query = session.createQuery(hql);
		List<Order> orders = query.list();
		tx1.commit();
		
		while(i < orders.size())
		{
			
			System.out.println("PROCESSING ORDER "+orders.get(i).getOrder_id());
			int ind = orders.get(i).getOrder_id();
			Vehicle veh = new Vehicle(ind,ind,ind,"Hyundai","A","P");
			Transaction tx = session.beginTransaction();
			Order ord = (Order) session.load(Order.class, veh.getOrder_id());
			veh.setOrder(ord);
			ord.setStatus("MANUFACTURED");
			session.save(veh);
			session.persist(veh);
			session.saveOrUpdate(ord);
			System.out.println("VEHICLE ID "+veh.getOrder_id()+" MANUFACTURED");
			tx.commit();
			custom.add(ord.getCustomer_id());
			i++;
		}
		orders.clear();
	}
	
	
	public void deliverCustomer() {
		String hql = "FROM Order AS O WHERE O.status = \'"+"MANUFACTURED"+"\'";
		Query query = session.createQuery(hql);
		List<Order> results = query.list();
		int i=0;
		while(i<results.size()) {
			Order ord = (Order) results.get(i);
			ord.setStatus("DELIVERED");
			Transaction tx = session.beginTransaction();
			session.update(ord);
			tx.commit();
			System.out.println("ORDER "+ord.getOrder_id()+"DELIVERED");
			i++;
		}
	}
	public void contactCustomer() {
		String hql = "FROM Order AS O WHERE O.status = \'"+"MANUFACTURED"+"\'";
		Query query = session.createQuery(hql);
		List<Order> results = query.list();
		int i=0;
		while(i<results.size()) {
			Customer cust = session.load(Customer.class, results.get(i).getCustomer_id());
			this.sendMail(cust);
			i++;
		}
		
		
	}
	public void sendMail(Customer cust) {
		String toemail= cust.getEmail();
		String fromemail = "aebcd@gmail.com";
		String local = "smtp.gmail.com";
		String body = "Dear "+cust.getName()+"\nYou order for the car has been shipped .\nThank You\n";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host",local);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");

	    properties.put("mail.smtp.port", "587"); 
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("eabcd8235@gmail.com", "04023155878");
	        }
	    }
		);
		 

		
		try {
			javax.mail.internet.MimeMessage message  = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromemail));
			message.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(toemail));
			message.setSubject("CAR DELIVERY NOTIFICATION");
			message.setText(body);
			javax.mail.Transport.send(message);
			
		}
		catch(MessagingException mex){
			mex.printStackTrace();
		}
		

		}

	
	public void exitsystem() {
		session.close();
		System.out.println("THANK YOU!!!");
		
	}
	
	
	
	
	
	
	
	
}
