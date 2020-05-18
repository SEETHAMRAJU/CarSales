package My_Project.dbms;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;




@Entity
@Table(name = "vehicle")
public class Vehicle {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "native")
	private int vehicle_id;
	
	private int engine_no, order_id, chassis_no;
	String manufacturer, fuel, transmission;
	
	@OneToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name="vehicle_id",referencedColumnName = "vehicle_id")
	private Order order;
	
	public Vehicle(int engine_no, int order_id, int chassis_no, String manufacturer, String fuel, String transmission) {
		this.engine_no = engine_no;
		this.order_id = order_id;
		this.chassis_no = chassis_no;
		this.manufacturer = manufacturer;
		this.fuel = fuel;
		this.transmission = transmission;
	}

	public void setOrder(Order ord) {
		this.order = ord;
	}
	public int getVehicle() {
		return this.vehicle_id;
	}
	public void setVehicle(int veh_id) {
		this.vehicle_id = veh_id;
	}
	
	
	public int getEngine_no() {
		return engine_no;
	}
	public void setEngine_no(int engine_no) {
		this.engine_no = engine_no;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getChassis_no() {
		return chassis_no;
	}
	public void setChassis_no(int chassis_no) {
		this.chassis_no = chassis_no;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public int getVehicle_id() {
		return vehicle_id;
	}
	
	

}
