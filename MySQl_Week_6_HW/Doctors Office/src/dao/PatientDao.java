package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Appointment;
import entity.Insurance;
import entity.Patient;

public class PatientDao {

	private Connection connection;
	private final String GET_PATIENTS_QUERY = "SELECT * FROM patients";
	private final String GET_PATIENT_BY_ID_QUERY = "SELECT * FROM patients WHERE id = ?";
	private final String CREATE_NEW_PATIENT_QUERY = (
			"INSERT INTO patients(first_name, last_name, street, city, state, zip, phone_number) VALUES (? ? ? ? ? ? ?");
	private final String DELETE_PATIENT_BY_ID_QUERY = "DELETE FROM patients WHERE id = ?";
	private final String UPDATE_PATIENT_BY_ID_QUERY = "UPDATE patients SET first_name = ?, "
			+ "last_name = ?, street = ?, city = ?, state = ?, zip = ?, phone_number = ? WHERE id = ?";
	private AppointmentsDao appointmentsDao = new AppointmentsDao();
	private InsuranceDao insuranceDao = new InsuranceDao();
	
	public PatientDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Patient> getPatients() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PATIENTS_QUERY).executeQuery();
		List<Patient> patients = new ArrayList<Patient>();
		
		while (rs.next()) {
			patients.add(populatePatient(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getInt(7),
					rs.getInt(8)));
		}
		
		return patients;
	}

	public Patient getPatientById(int patientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PATIENT_BY_ID_QUERY);
		ps.setInt(1, patientId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePatient(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getInt(7),
					rs.getInt(8));
	}
	
	public void createNewPatient(String firstName, String lastName, String street, String city, String state, int zip,
			int phoneNumber) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PATIENT_QUERY);
		ps.setString(2, firstName);
		ps.setString(3, lastName);		
		ps.setString(4, street);
		ps.setString(5, city);
		ps.setString(6, state);
		ps.setInt(7, zip);
		ps.setInt(8, phoneNumber);
		ps.executeUpdate();
	}
	
	public void updatePatient(int patientId, String firstName, String lastName, String street, String city, String state, int zip,
			int phoneNumber) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PATIENT_BY_ID_QUERY);
		ps.setInt(1, patientId);
		ps.setString(2, firstName);
		ps.setString(3, lastName);		
		ps.setString(4, street);
		ps.setString(5, city);
		ps.setString(6, state);
		ps.setInt(7, zip);
		ps.setInt(8, phoneNumber);
		ps.executeUpdate();
	}
	
	public void deletePatient(int patientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PATIENT_BY_ID_QUERY);
		ps.executeUpdate();
	}
	
	private Patient populatePatient(int patientId, String firstName, String lastName, String street, String city, 
			String state, int zip, int phone) throws SQLException {
		
		List<Appointment> appointments = appointmentsDao.getAppointments(patientId);
		List<Insurance> insurance = insuranceDao.getInsurance(patientId);
		
		return new Patient(patientId, firstName, lastName, street, city, state, zip, phone, appointments, insurance);
	}
	
}
