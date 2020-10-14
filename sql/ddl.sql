DROP DATABASE IF EXISTS cars;
CREATE DATABASE cars;
USE cars;


CREATE TABLE customer (
	customer_id int NOT NULL AUTO_INCREMENT,
	name varchar(100),
	email varchar(100),
	PRIMARY KEY (customer_id)
);


CREATE TABLE orders (
	order_id int NOT NULL AUTO_INCREMENT,
	status varchar(30),
	vehicle_id int,
	customer_id int,
	dealer_id int,
	PRIMARY KEY (order_id)
);


CREATE TABLE dealer(
	dealer_id int NOT NULL AUTO_INCREMENT,
	name varchar(100),
	PRIMARY KEY (dealer_id)
);

CREATE TABLE vehicle(
	vehicle_id int NOT NULL AUTO_INCREMENT,
	engine_no int,
	fuel varchar(10),
	Transmission varchar(1),
	manufacturer varchar(100),
	chassis_no int,
	order_id int,
	PRIMARY KEY (vehicle_id)
);

CREATE TABLE cust_deal(
	cust_id int,
	dealer_id int,
	PRIMARY KEY (cust_id,dealer_id)
);



ALTER TABLE orders ADD CONSTRAINT fk_ord_veh FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id);
ALTER TABLE orders ADD CONSTRAINT fk_ord_cus FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
ALTER TABLE orders ADD CONSTRAINT fk_ord_dealer FOREIGN KEY (dealer_id) REFERENCES dealer(dealer_id);
ALTER TABLE vehicle ADD CONSTRAINT fk_veh_ord FOREIGN KEY (order_id) REFERENCES orders(order_id);
ALTER TABLE cust_deal ADD CONSTRAINT fk_cd_cust FOREIGN KEY (cust_id) REFERENCES customer(customer_id);
ALTER TABLE cust_deal ADD CONSTRAINT fk_cd_del FOREIGN KEY (dealer_id) REFERENCES dealer(dealer_id);

