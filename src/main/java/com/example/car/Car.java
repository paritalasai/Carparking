/*package com.example.car;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name="car")
public class Car {
	private static final long serialVersionUID = 1L;
	public Car()
	{
		
	}	
	@Id
	@GeneratedValue
private Integer id;
private String carname;
private String owner;
private long carnumber;
private String cartype;
public Date getCheckout() {
	return checkout;
}

public void setCheckout(Date checkout) {
	this.checkout = checkout;
}
@Temporal(TemporalType.TIMESTAMP)
private Date checkin;
@Transient
private Date checkout;
@Transient
private String parkingtime;
@Transient
private float price;
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getParkingtime() {
	return parkingtime;
}
public void setParkingtime(String hours) {
	this.parkingtime = hours; 
}
public Date getCheckin() {
	return checkin;
}
public void setCheckin(Date checkin) {
	this.checkin = checkin;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCarname() {
	return carname;
}
public void setCarname(String carname) {
	this.carname = carname;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public long getCarnumber() {
	return carnumber;
}
public void setCarnumber(long carnumber) {
	this.carnumber = carnumber;
}
public String getCartype() {
	return cartype;
}
public void setCartype(String cartype) {
	this.cartype = cartype;
}
}
*/
