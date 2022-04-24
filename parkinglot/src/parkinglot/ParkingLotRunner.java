package parkinglot;

import java.time.LocalTime;
import java.util.Scanner;

public class ParkingLotRunner {

	public static void main(String[] args) {
		ParkingLot pObj = new ParkingLot();
		Scanner scan = new Scanner(System.in);
		Boolean bool = true;
		while (bool) {
			for (int i = 1; i < 4; i++) {
				try {
					System.out.println("Floor " + i + " " + pObj.emptySlots(i));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Enter the vehicle number");
			int number = scan.nextInt();
			scan.nextLine();
			System.out.println("1.Car\n2.MotorCycle\n3.Large\n4.Electric");
			System.out.println("Enter the Vehicle type");
			int val = scan.nextInt();
			VehicleSize type = null;
			switch (val) {
			case 1: {
				type = VehicleSize.Compact;
				break;
			}
			case 2: {
				type = VehicleSize.Motorcycle;
				break;
			}
			case 3: {
				type = VehicleSize.Large;
				break;
			}
			case 4: {
				type = VehicleSize.Electric;
				break;
			}
			}
			if (type == null) {
				System.out.println("Invalid vehicle type");
				continue;
			}

			System.out.println("Enter the floor");
			int floor = scan.nextInt();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleNumber(number);
			vehicle.setVehicleType(type);
			LocalTime myObj1 = LocalTime.now();
			String entryTime = myObj1.toString();
			Token token = new Token();
			int currToken = pObj.tokennumber();
			token.setTokenNumber(currToken);
			token.setEntryTime(entryTime);
			token.setFloor(floor);
			token.setVehicleType(type);
			try {
				System.out.println(pObj.bookSlot(vehicle, floor, type, token));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			scan.nextLine();
			System.out.println("Do you want to pay at customer info portal");
			String info = scan.nextLine();
			if (info.equals("Yes")) {
				System.out.println("Enter the hours for parking");
				int time = scan.nextInt();
				System.out.println("The price is " + pObj.paymentCalculator(time));
				System.out.println("Thanks for coming");
			}
			scan.nextLine();
			System.out.println("Do you want to exit");
			String exit = scan.nextLine();
			if (exit.equals("Yes")) {
				System.out.println("Enter the vehicle number");
				int num = scan.nextInt();
				System.out.println("Enter the token number");
				int token1 = scan.nextInt();
				int price = 0;
				try {
					price = pObj.exit(num, token1);
					System.out.println("The price is " + price);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				Payment payment = new Payment();
				payment.setAmount(price);
				payment.setTokenNumber(token1);
				payment.setPaymentStatus(true);
				if (!info.equals("Yes")) {
					scan.nextLine();
					System.out.println("1.Cash\n2.Credit card");
					System.out.println("Enter the payment type");
					int val1 = scan.nextInt();
					if (val1 == 1) {
						payment.setPaymentType(val1);
					} else if (val1 == 2) {
						System.out.println("Enter credit card number");
						int credit = scan.nextInt();
						payment.setPaymentType(val1);
						payment.setCreditCardNumber(credit);
					} else {
						System.out.println("Enter valid number");
					}
					try {
						System.out.println(pObj.payment(payment, num, token1));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					try {
						System.out.println(pObj.payment(payment, num, token1));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		scan.close();
	}
}
