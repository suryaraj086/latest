package hms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempStore {
	Map<String, Hotel> hotelMap = new HashMap<String, Hotel>();
	Map<Integer, List<Hotel>> ratingMap = new HashMap<Integer, List<Hotel>>();
	Map<String, List<Hotel>> locationMap = new HashMap<String, List<Hotel>>();
	Map<Integer, List<Hotel>> roomsMap = new HashMap<Integer, List<Hotel>>();

	public TempStore() {

		Hotel hotel = new Hotel();
		hotel.setHotelName("H1");
		hotel.setLocation("chennai");
		hotel.setPrice(100);
		hotel.setRating(5);
		hotel.setRooms(100);
		hotelMap.put("H1", hotel);
		List<Hotel> arr = new ArrayList<>();
		arr.add(hotel);
		ratingMap.put(hotel.getRating(), arr);
		List<Hotel> locarr = new ArrayList<>();
		locarr.add(hotel);
		locationMap.put(hotel.getLocation(), locarr);

		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("H2");
		hotel1.setLocation("bangalore");
		hotel1.setPrice(80);
		hotel1.setRating(5);
		hotel1.setRooms(90);
		hotelMap.put("H2", hotel1);
		if (ratingMap.get(hotel1.getRating()) == null) {
			arr = new ArrayList<>();
		}
		arr.add(hotel1);
		ratingMap.put(hotel1.getRating(), arr);
		if (locationMap.get(hotel1.getLocation()) == null) {
			locarr = new ArrayList<>();
		}
		locarr.add(hotel1);
		locationMap.put(hotel1.getLocation(), locarr);

		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("H3");
		hotel2.setLocation("bangalore");
		hotel2.setPrice(70);
		hotel2.setRating(3);
		hotel2.setRooms(90);
		hotelMap.put("H3", hotel2);
		if (ratingMap.get(hotel2.getRating()) == null) {
			arr = new ArrayList<>();
		}
		arr.add(hotel2);
		ratingMap.put(hotel2.getRating(), arr);
		if (locationMap.get(hotel2.getLocation()) == null) {
			locarr = new ArrayList<>();
		}
		locarr.add(hotel2);
		locationMap.put(hotel2.getLocation(), locarr);

	}
}
