package parkinglot;

public class ParkingLot {

	TempStore cache = new TempStore();

	public String bookSlot(int floor, VehicleSize type, Token token, boolean payment) throws Exception {
		return cache.bookSlot(floor, type, token, payment);
	}

	public void checkSize(int size) throws Exception {
		if (size <= 0) {
			throw new Exception("Fully Occupied");
		}
	}

	public String emptySlots(VehicleSize type) throws Exception {
		return cache.emptySlots(type);
	}

	public int exit(int vehicleNumber, int tokenNumber) throws Exception {
		return cache.exitSlot(tokenNumber, vehicleNumber);
	}

	public int calculate(int vehicleNumber, int tokenNumber) throws Exception {
		return cache.payment(vehicleNumber, tokenNumber);
	}

	public String payment(UserDetails user, int tokenNum) throws Exception {

		return cache.onlinePortalPayment(user, tokenNum);
	}

	public int paymentCalculator(long time) {
		return cache.paymentCalculator(time);
	}

	public int walletAmountChecker(int tokenNum) throws Exception {
		return cache.walletAmountChecker(tokenNum);
	}

	public String checkPaidStatus(int tokenNum) {
		if (cache.userMap.containsKey(tokenNum)) {
			return "Yes";
		}
		return "No";
	}

	public UserDetails getUser(int userId) throws Exception {
		if (cache.existingCustomer.get(userId) != null) {
			int token = cache.existingCustomer.get(userId);
			return cache.userMap.get(token);
		}
		throw new Exception("Customer not found");
	}

	public void balanceSetter(int token, int balance) {
		cache.balanceSetter(token, balance);
	}

	public void floorCreator(int floor, int spots) {
		cache.floorCreator(floor, spots);
	}

	public int tokennumber() {
		return cache.tokenNumber();
	}

	public int freeFloor(VehicleSize type) throws Exception {
		return cache.freeFloor(type);
	}

	public int userNumber() {
		return cache.userNumber();
	}
}
