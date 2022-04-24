package parkinglot;

public class Token {
	int tokenNumber = 1;
	String entryTime;
	String exitTime;
	int vehicleNumber;
	VehicleSize VehicleType;
	int floor;

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public VehicleSize getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(VehicleSize type) {
		VehicleType = type;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(int tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	@Override
	public String toString() {
		return "Token [tokenNumber=" + tokenNumber + ", entryTime=" + entryTime + ", exitTime=" + exitTime
				+ ", vehicleNumber=" + vehicleNumber + ", VehicleType=" + VehicleType + ", floor=" + floor + "]";
	}

}
