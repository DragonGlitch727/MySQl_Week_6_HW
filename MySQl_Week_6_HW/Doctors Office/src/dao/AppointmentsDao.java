package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Appointment;

public class AppointmentsDao {
	
	private final String GET_APPOINTMENTS_BY_PATIENT_ID_QUERY = "SELECT * FROM appointments WHERE patient_id = ?";
	private final String UPDATE_APPOINTMENTS_BY_PATIENT_ID_QUERY = "UPDATE appointments SET date_time = ? WHERE patient_id = ?";
	private final String DELETE_APPOINTMENTS_BY_PATIENT_ID_QUERY = "DELETE FROM appointments WHERE patient_id = ?";
	private Connection connection;
	
	public AppointmentsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Appointment> getAppointments(int patientId) throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_APPOINTMENTS_BY_PATIENT_ID_QUERY).executeQuery();
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		while (rs.next()) {
			appointments.add(new Appointment(rs.getInt(1), rs.getString(3)));
		}
		return appointments;
	}
	
	public void updateAppointmentsByPatientId(int patientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_APPOINTMENTS_BY_PATIENT_ID_QUERY);
		ps.setInt(1, appointmentsId);
		ps.setDate_time(2, date_time);
	}

	public void deleteAppointmentByPatientId(int patientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_APPOINTMENTS_BY_PATIENT_ID_QUERY);
		ps.executeUpdate();
	}
}
