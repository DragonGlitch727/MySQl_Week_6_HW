package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Insurance;

public class InsuranceDao {

	private final String GET_INSURANCE_QUERY = "SELECT * FROM insurance WHERE patient_id = ?";
	private final String UPDATE_INSURANCE_BY_PATIENT_ID_QUERY = "UPDATE insurance SET name = ?, "
			+ "description = ? WHERE patient_id = ?";
	private final String DELETE_INSURANCE_BY_PATIENT_ID_QUERY = "DELETE FROM insurance WHERE patient_id = ?";
	private Connection connection;
	
	public InsuranceDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Insurance> getInsurance(int patientId) throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_INSURANCE_QUERY).executeQuery();
		List<Insurance> insurance = new ArrayList<Insurance>();
		
		while (rs.next()) {
			insurance.add(new Insurance(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return insurance;
	}
	
	public void updateInsuranceBy
	
	public void deleteInsuranceByPatientId(int patientId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_INSURANCE_BY_PATIENT_ID_QUERY);
		ps.executeUpdate();
	}
	
}
