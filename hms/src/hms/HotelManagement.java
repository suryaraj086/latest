package hms;



public class HotelManagement {

	TempStore tempStore = new TempStore();

	public String sortByLocation(String location) {
		return tempStore.sortByLocation(location);
	}

	public String sortHotelName() {
		return tempStore.sortHotelName();
	}

	public String sortRating() {
		return tempStore.sortRating();
	}

	public String sortRooms() {
		return tempStore.sortRooms();
	}

	public int bookingNumber() {
		return tempStore.bookingNumber;
	}

}
