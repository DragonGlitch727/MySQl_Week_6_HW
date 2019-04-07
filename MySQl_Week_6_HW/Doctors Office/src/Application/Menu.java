package Application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Appointments", "Display Date and Times of Appointments", "Create Date and Time for an Appointment", "Delete Date and Time for an appointment");

	public void start() {
		
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				//displayAppointments();
			} else if (selection.equals("2")) {
				//displayDateTime();
			} else if (selection.equals("3")) {
				//createDateTime();
			} else if (selection.equals("4")) {
				//deleteDateTime();
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
	
}
