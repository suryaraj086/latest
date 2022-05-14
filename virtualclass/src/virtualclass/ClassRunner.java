package virtualclass;

import java.util.Scanner;

public class ClassRunner {
	public static void main(String args[]) {
		VirtualClass vc = new VirtualClass();
		Scanner scan = new Scanner(System.in);
		Boolean temp = new Boolean(true);
		while (temp) {
			System.out.println("1.Signin\n2.Signup");
			System.out.println("Enter the id");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the password");
			String password = scan.nextLine();
			Role val = null;
			try {
				val = vc.loginAndRole(id, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (val) {
			case Admin:
				System.out.println("Edit profile");
				System.out.println("Study materials");
				System.out.println("Doubts");
				System.out.println("Answers");
				int num = scan.nextInt();
				switch (num) {
				case 1:
					Details obj = vc.getProfile(id);

					try {
						vc.editProfile(obj, id);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println(vc.showStudyMaterials());
					break;
				case 3:
					System.out.println("Enter the question");
					String question = scan.nextLine();
					System.out.println(vc.askDoubt(question));
					break;
				case 4:
					
					break;

				default:
					break;
				}
				break;
			case Faculty:
				System.out.println("Edit profile");
				System.out.println("Study materials");
				System.out.println("Doubts");
				System.out.println("Answer the question");
				break;
			case Student:
				System.out.println("Edit profile");
				System.out.println("Study materials");
				System.out.println("Ask Doubts");
				System.out.println("Answers");
				break;
			default:
				break;
			}
		}
		scan.close();
	}
}
