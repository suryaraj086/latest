package parkinglot;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

	Cache cache = new Cache();

	public String bookSlot(Vehicle vehicle, int floor, VehicleSize type, Token token) throws Exception {
		Floor floorObj = cache.floorMap.get(floor);
		if (vehicle == null || floorObj == null) {
			throw new Exception("Invalid details");
		}
		int vehicleNumber = vehicle.getVehicleNumber();
		if (cache.vehicleMap.get(vehicleNumber) != null) {
			throw new Exception("vehicle already parked");
		}
		switch (type) {
		case Compact: {
			int compackSize = floorObj.getCompactSize();
			checkSize(compackSize);
			floorObj.setCompactSize(compackSize - 1);
			break;
		}
		case Motorcycle: {
			int motorCycle = floorObj.getMotorCycle();
			checkSize(motorCycle);
			floorObj.setMotorCycle(motorCycle - 1);
			break;
		}
		case Large: {
			int large = floorObj.getLargeSize();
			checkSize(large);
			floorObj.setMotorCycle(large - 1);
			break;
		}
		case Electric: {
			int electricSize = floorObj.getElectricSpot();
			checkSize(electricSize);
			floorObj.setElectricSpot(electricSize - 1);
			break;
		}
		case Handicap: {
			int handicapSize = floorObj.getHandicap();
			checkSize(handicapSize);
			floorObj.setElectricSpot(handicapSize - 1);
			break;
		}
		}
		cache.vehicleMap.put(vehicleNumber, vehicle);
		Map<Integer, Token> map = new HashMap<Integer, Token>();
		int currToken = token.getTokenNumber();
		map.put(currToken, token);
		cache.tokenMap.put(vehicle.getVehicleNumber(), map);
		return "Booked SucessFully and token number is " + currToken;
	}

	public void checkSize(int size) throws Exception {
		if (size <= 0) {
			throw new Exception("Fully Occupied");
		}
	}

	public String emptySlots(int floor) throws Exception {
		Floor floorObj = cache.floorMap.get(floor);
		if (floorObj == null) {
			throw new Exception("Floor not found");
		}

		return floorObj.toString();
	}

	public int exit(int vehicleNumber, int tokenNumber) throws Exception {
		Map<Integer, Token> map = cache.tokenMap.get(vehicleNumber);
		if (map == null) {
			throw new Exception("Vehicle number not found");
		}
		Token token = (Token) map.get(tokenNumber);
		if (token == null) {
			throw new Exception("Token number not found");
		}
		String entry = token.getEntryTime();
		LocalTime myObj1 = LocalTime.now();
		String exit = myObj1.toString();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(entry);
		Date date2 = format.parse(exit);
		long difference = date2.getTime() - date1.getTime();
		return paymentCalculator(difference / 1000);
	}

	public String payment(Payment payment, int vehicleNum, int tokenNum) throws Exception {
		Map<Integer, Token> tokenMap = cache.tokenMap.get(vehicleNum);
		if (tokenMap == null) {
			throw new Exception("Vehicle number not found");
		}
		Token token = (Token) tokenMap.get(tokenNum);
		int floor = token.getFloor();
		VehicleSize type = token.getVehicleType();
		Floor floorObj = cache.floorMap.get(floor);
		switch (type) {
		case Compact: {
			int compackSize = floorObj.getCompactSize();
			floorObj.setCompactSize(compackSize + 1);
		}
		case Motorcycle: {
			int motorCycle = floorObj.getMotorCycle();
			floorObj.setMotorCycle(motorCycle + 1);
		}
		case Large: {
			int large = floorObj.getLargeSize();
			floorObj.setMotorCycle(large + 1);
		}
		case Electric: {
			int electricSize = floorObj.getElectricSpot();
			floorObj.setElectricSpot(electricSize + 1);
		}
		case Handicap: {
			int handicapSize = floorObj.getHandicap();
			floorObj.setElectricSpot(handicapSize + 1);
		}
		}
		cache.payment.put(tokenNum, payment);
		cache.vehicleMap.remove(vehicleNum);
		cache.tokenMap.remove(tokenNum);
		return "Payment Successful";
	}

	public int paymentCalculator(long time) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int price = 4;
		map.put(10, 3);
		map.put(20, 2);
		for (int i = 1; i <= time; i++) {
			if (map.get(i) != null) {
				price += map.get(i);
			}
		}
		return price;
	}

	public int tokennumber() {
		return cache.tokennumber();
	}

}
