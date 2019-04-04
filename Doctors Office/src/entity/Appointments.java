package entity;

public class Appointments {
	private int appointmentsId;
	private String date_time;
	
	public Appointments(int appointmentsId, String date_time) {
		this.setAppointmentsId(appointmentsId);
		this.setDate_time(date_time);
	}

	public int getAppointmentsId() {
		return appointmentsId;
	}

	public void setAppointmentsId(int appointmentsId) {
		this.appointmentsId = appointmentsId;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	

	
}
