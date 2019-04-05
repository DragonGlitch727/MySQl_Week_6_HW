package entity;

public class Appointments {
	private int appointmentsId;
	private String date;
	private String time;
	
	public Appointments(int appointmentsId, String date, String time) {
		this.setAppointmentsId(appointmentsId);
		this.setDate(date);
		this.setTime(time);
	}

	public int getAppointmentsId() {
		return appointmentsId;
	}

	public void setAppointmentsId(int appointmentsId) {
		this.appointmentsId = appointmentsId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
