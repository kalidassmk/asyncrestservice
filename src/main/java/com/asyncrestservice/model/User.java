package com.asyncrestservice.model;

/**
 * @author Kalidass Mahalingam
 *
 */
public class User {

	public User(String firstName, String lastName, String address, String mobileNumb) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNumb = mobileNumb;
	}

	private String firstName;

	private String lastName;

	private String address;

	private String mobileNumb;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumb() {
		return mobileNumb;
	}

	public void setMobileNumb(String mobileNumb) {
		this.mobileNumb = mobileNumb;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", mobileNumb="
				+ mobileNumb + "]";
	}

	
}
