package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Appointment;

public class AppointmentsDao {
	
	private final String GET_APPOINTMENTS_QUERY = "SELECT * FROM appointments WHERE id = ?";
	private Connection connection;
	
	public AppointmentsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Appointment> getAppointments() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_APPOINTMENTS_QUERY).executeQuery();
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		while (rs.next()) {
			appointments.add(allAppointments(rs.getInt(1), rs.getString(2)));
		}
		return appointments;
	}

	private Appointment allAppointments(int id, String date_time) {
		return new Appointment(id, date_time);
	}
	public Appointment getAppointmentById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_APPOINTMENTS_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return allAppointments(rs.getInt(1), rs.getString(2));
	}
}
