package entity;

import java.io.Serializable;

public class DescriptionRoom implements Serializable {

	private String name;
	private int place;
	private String classApartments;
	private boolean status;
	public User user;
	private int price;
	
	public int getPlace() {
		return place;
	}
	
	public void setPlace(int place) {
		this.place = place;
	}
	
	public String getClassApartments() {
		return classApartments;
	}
	
	public void setClassApartments(String classApartments) {
		this.classApartments = classApartments;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
