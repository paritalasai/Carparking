package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parking")
public class ParkingDetails implements Serializable
{

	public String getCarowner() {
		return carowner;
	}
	public void setCarowner(String carowner) {
		this.carowner = carowner;
	}
	public long getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(long l) {
		this.carnumber = l;
	}
	public Date getCheckintime() {
		return checkintime;
	}
	public void setCheckintime(Date checkintime) {
		this.checkintime = checkintime;
	}
	public Date getCheckouttime() {
		return checkouttime;
	}
	public void setCheckouttime(Date checkouttime) {
		this.checkouttime = checkouttime;
	}
	public String getTimeofparking() {
		return timeofparking;
	}
	public void setTimeofparking(String timeofparking) {
		this.timeofparking = timeofparking;
	}
	public float getPriceofparking() {
		return priceofparking;
	}
	public void setPriceofparking(float priceofparking) {
		this.priceofparking = priceofparking;
	}
	private String carowner;
	@Id
	private long carnumber;
	private Date checkintime;
	private Date checkouttime;
	private String timeofparking;
	private float priceofparking;
	
	
	
}
