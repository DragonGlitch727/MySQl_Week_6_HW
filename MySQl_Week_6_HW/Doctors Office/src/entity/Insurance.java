package entity;

public class Insurance {
	
		private int insuranceId;
		private String name;
		private String description;
		
		public Insurance(int insuranceId, String name, String description) {
			this.setInsuranceId(insuranceId);
			this.setName(name);
			this.setDescription(description);
		}

		public int getInsuranceId() {
			return insuranceId;
		}

		public void setInsuranceId(int insuranceId) {
			this.insuranceId = insuranceId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		

}
