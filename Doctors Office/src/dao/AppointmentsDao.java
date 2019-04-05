package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Appointment;

public class AppointmentsDao {
	
	private final String GET_APPOINTMENTS_QUERY = "SELECT * FROM appointments WHERE patient_id = ?";
	private Connection connection;
	
	public AppointmentsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Appointment> getAppointments(int patientId) throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_APPOINTMENTS_QUERY).executeQuery();
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		while (rs.next()) {
			appointments.add(new Appointment(rs.getInt(1), rs.getString(3)));
		}
		return appointments;
	}

}
