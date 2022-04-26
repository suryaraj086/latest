package hms;

public class ObjectGenerator {

	public static UsersInfo userSetter(int userId, String userName, int bookingCost, String hotelName) {
		UsersInfo user = new UsersInfo();
		user.setUserID(userId);
		user.setUserName(userName);
		user.setHotelName(hotelName);
		user.setBookingCost(bookingCost);
		return user;
	}
}
