package hms;

import java.util.Comparator;

public class Compare implements Comparator<Hotel> {

	String inp = "";

	public Compare(String string) {
		this.inp = string;
	}

	@Override
	public int compare(Hotel customer1, Hotel customer2) {

		switch (inp) {
		case "rating": {
			int ratingCompare = customer1.getRating().compareTo(customer2.getRating());
			return ratingCompare;
		}
		case "rooms": {
			int roomCompare = customer1.getRooms().compareTo(customer2.getRooms());
			return roomCompare;

		}
		case "name": {
			int nameCompare = customer1.getHotelName().compareTo(customer2.getHotelName());
			return nameCompare;
		}

		}
		return 0;
	}
}
