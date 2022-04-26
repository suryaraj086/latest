package hms;

import java.util.Scanner;

public class HotelManagementRunner {

	public static void main(String[] args) {
		HotelManagement hObj = new HotelManagement();
		Scanner scan = new Scanner(System.in);

		boolean bool = true;
		while (bool) {
			System.out.println(
					"1.Sort hotels by name\n2.Sort hotels by rating\n3.Sort hotels by rooms\n4.Sort hotels by location ");
			System.out.println("Enter the input");
			int value = scan.nextInt();
			switch (value) {
			case 1: {
				System.out.println(hObj.sortHotelName());
				break;
			}
			case 2: {
				System.out.println(hObj.sortRating());
				break;
			}
			case 3: {
				System.out.println(hObj.sortRooms());
				break;
			}
			case 4: {
				System.out.println(hObj.sortByLocation("chennai"));
				break;
			}
			case 5: {
				scan.nextLine();
				System.out.println("Enter user name");
				String name = scan.nextLine();
				System.out.println("Enter the hotel name");
				String hotelName = scan.nextLine();
				System.out.println("Enter the booking cost");
				int cost = scan.nextInt();
				int bookingNumber = hObj.bookingNumber();
				ObjectGenerator.userSetter(bookingNumber, name, cost, hotelName);
				System.out.println(hObj.sortByLocation("chennai"));
				break;
			}

			default: {
				bool = false;
			}
			}
		}
		scan.close();
	}
}
