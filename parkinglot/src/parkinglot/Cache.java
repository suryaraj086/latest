package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Cache {

	int token = 1;
	Map<Integer, Floor> floorMap = new HashMap<Integer, Floor>();
	Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
	Map<Integer, Map<Integer, Token>> tokenMap = new HashMap<Integer, Map<Integer, Token>>();
	Map<Integer, Payment> payment = new HashMap<Integer, Payment>();

	Cache() {
		for (int i = 1; i < 4; i++) {
			Floor floor = new Floor();
			floorMap.put(i, floor);
		}
	}

	public int tokennumber() {
		return ++token;
	}
}
