package entity;

import java.util.List;

public class Patient {

	private int patientId;
	private String firstName;
	private String lastName;
	private String street;
	private String state;
	private String city;
	private int zip;
	private int phoneNumber;
	private List<Appointments> appointments;
	private List<Insurance> insurance;
	
	public Patient(int patientId, String firstName, String lastName, String street, String state, String city, int zip, int phoneNumber, List<Appointments> appointments, List<Insurance> insurance) {
	this.setPatientId(patientId);
	this.setFirstName(firstName);
	this.setLastName(lastName);
	this.setStreet(street);
	this.setState(state);
	this.setCity(city);
	this.setZip(zip);
	this.setPhoneNumber(phoneNumber);
	this.setAppointments(appointments);
	this.setInsurance(insurance);
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Appointments> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	public List<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<Insurance> insurance) {
		this.insurance = insurance;
	}

	
}

