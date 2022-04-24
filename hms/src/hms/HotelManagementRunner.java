package hms;

import java.util.Scanner;

public class HotelManagementRunner {

	public static void main(String[] args) {
		HotelManagement hObj = new HotelManagement();
		Scanner scan = new Scanner(System.in);

		boolean bool = true;
		while (bool) {
			System.out.println("Enter the input");
			int value = scan.nextInt();
			switch (value) {
			case 1: {
				System.out.println(hObj.sortByHotel());
				break;
			}
			case 2: {
				System.out.println(hObj.sortByRating());
				break;
			}

			case 3: {
				String loc = "chennai";
				System.out.println(hObj.sortByLocation(loc));
				break;
			}

			case 4: {
				System.out.println(hObj.sortByRooms());
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
