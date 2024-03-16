package org.servlets.Model;

public class User {

	private int id;
    private String name;
    private String email;
    private String phone;
    private String dob;  // Date of Birth
    private boolean subscribed;  // Checkbox
    private String gender;  // Radio button
    private String country;  // Dropdown
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String phone, String dob, boolean subscribed, String gender,
			String country) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.subscribed = subscribed;
		this.gender = gender;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
    
    

}
