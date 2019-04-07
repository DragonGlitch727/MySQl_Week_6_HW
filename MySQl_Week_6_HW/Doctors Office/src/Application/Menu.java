package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.AppointmentsDao;
import entity.Appointment;

public class Menu {
	
	private AppointmentsDao appointmentsDao = new AppointmentsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Appointments", "Display Date and Times of Appointments", "Create Date and Time for an Appointment", "Delete Date and Time for an appointment");

	public void start() {
		
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
		try {
			
			if (selection.equals("1")) {
				displayAppointments();
			} else if (selection.equals("2")) {
				displayDateTime();
			} else if (selection.equals("3")) {
				//createDateTime();
			} else if (selection.equals("4")) {
				//deleteDateTime();
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n---------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayAppointments() throws SQLException { 
		List<Appointment> appointments = appointmentsDao.getAppointments();
		for (Appointment appointment : appointments) {
			System.out.println(appointment.getAppointmentsId() + ": " + appointment.getDate_time());
		}
	}
	
	private void displayDateTime() throws SQLException {
		System.out.println("Enter team id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Appointment appointment = appointmentsDao.getAppointmentById(id);
		System.out.println(appointment.getAppointmentsId() + ": " + appointment.getAppointmentsId());
	}
}
