package entity;

import java.io.Serializable;

public class Bid implements Serializable {

	private int place;
	private String classApartments;
	private String time;
	public User user;
	private boolean review;
	
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
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}

}
