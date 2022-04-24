package hms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HotelManagement {

	public String sortByHotel() {
		TempStore tempStore = new TempStore();
		Map<String, Hotel> map = tempStore.hotelMap;
		ArrayList<String> sortKeys = new ArrayList<String>(map.keySet());
		Collections.sort(sortKeys, Collections.reverseOrder());
		String out = "";
		for (String x : sortKeys) {
			out += map.get(x);
			out += "\n";
		}
		return out;
	}

	public String sortByRooms() {
		TempStore tempStore = new TempStore();
		Map<Integer, List<Hotel>> map = tempStore.roomsMap;
		ArrayList<Integer> sortKeys = new ArrayList<Integer>(map.keySet());
		Collections.sort(sortKeys, Collections.reverseOrder());
		String out = "";
		for (Integer x : sortKeys) {
			out += map.get(x);
			out += "\n";
		}
		return out;
	}

	public String sortByRating() {
		TempStore tempStore = new TempStore();
		Map<Integer, List<Hotel>> map = tempStore.ratingMap;
		ArrayList<Integer> sortKeys = new ArrayList<Integer>(map.keySet());
		Collections.sort(sortKeys, Collections.reverseOrder());
		String out = "";
		for (Integer x : sortKeys) {
			out += map.get(x);
			out += "\n";
		}
		return out;
	}

	public String sortByLocation(String location) {
		TempStore tempStore = new TempStore();
		Map<String, List<Hotel>> map = tempStore.locationMap;
		String out = "";
		out += map.get(location);
		return out;
	}

}
