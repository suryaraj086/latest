package hms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempStore {

	List<Hotel> hotelList = new ArrayList<Hotel>();
	int bookingNumber = 0;

	public TempStore() {

		Hotel hotel = new Hotel();
		hotel.setHotelName("H1");
		hotel.setLocation("chennai");
		hotel.setPrice(100);
		hotel.setRating(5);
		hotel.setRooms(100);

		Hotel hotel1 = new Hotel();
		hotel1.setHotelName("H2");
		hotel1.setLocation("bangalore");
		hotel1.setPrice(80);
		hotel1.setRating(5);
		hotel1.setRooms(90);

		Hotel hotel2 = new Hotel();
		hotel2.setHotelName("H3");
		hotel2.setLocation("bangalore");
		hotel2.setPrice(70);
		hotel2.setRating(3);
		hotel2.setRooms(90);

		hotelList.add(hotel);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
	}

	public int number() {
		return bookingNumber++;
	}

	public String sortByLocation(String location) {
		List<Hotel> list = hotelList;
		String out = "";
		for (int i = 0; i < list.size(); i++) {
			Hotel hotel = (Hotel) list.get(i);
			if (hotel.getLocation().equals(location)) {
				out += hotel.toString();
				out += "\n";
			}

		}
		return out;
	}

	public String sortHotelName() {
		List<Hotel> hotel = hotelList;
		Collections.sort(hotel, new Compare("name"));
		String out = "";
		for (int i = hotel.size() - 1; i >= 0; i--) {
			out += hotel.get(i);
			out += "\n";
		}
		return out;
	}

	public String sortRating() {
		List<Hotel> hotel = hotelList;
		Collections.sort(hotel, new Compare("rating"));
		String out = "";
		for (int i = hotel.size() - 1; i >= 0; i--) {
			out += hotel.get(i);
			out += "\n";
		}
		return out;
	}

	public String sortRooms() {
		List<Hotel> hotel = hotelList;
		Collections.sort(hotel, new Compare("rooms"));
		String out = "";
		for (int i = hotel.size() - 1; i >= 0; i--) {
			out += hotel.get(i);
			out += "\n";
		}
		return out;
	}

	public int bookingNumber() {
		return bookingNumber;
	}

}
