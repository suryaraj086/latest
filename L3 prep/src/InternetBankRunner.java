import java.util.Scanner;

public class InternetBankRunner {

	public static void main(String[] args) {
		InternetBanking InternetObj = new InternetBanking();
		Scanner scan = new Scanner(System.in);
		boolean bool = true;
		long id = 0;
		while (bool) {
			System.out.println("1.Login\n2.Create New Account");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the user id");
				id = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter the password");
				String password = scan.nextLine();
				String loginCheck = "";
				try {
					loginCheck = InternetObj.login(id, password);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// customer
				if (loginCheck.equals("Customer")) {
					System.out.println("Login successful");
					bool = false;
					boolean temp = true;
					while (temp) {
						System.out.println(
								"1.Add new account\n2.Balance Check\n3.Bank Transfer\n4.Transaction History\n5.Loan Status\n6.Apply Loan");
						int option = scan.nextInt();
						switch (option) {
						case 1:
							try {
								System.out.println(InternetObj.addAccount(id, loginCheck));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 2:
							long account1 = InternetObj.account(id);
							if (account1 == 0) {
								System.out.println("Enter the from account number");
								account1 = scan.nextLong();
							}
							try {
								System.out.println(InternetObj.checkBalance(account1, loginCheck, id));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 3:
							long fromAcc = InternetObj.account(id);
							if (fromAcc == 0) {
								System.out.println("Enter the from account number");
								fromAcc = scan.nextLong();
							}
							System.out.println("Enter the to account number");
							long toAcc = scan.nextLong();
							System.out.println("Enter the amount");
							int amount = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter remarks ");
							String remarks = scan.nextLine();
							try {
								System.out.println(
										InternetObj.transaction(fromAcc, amount, toAcc, id, loginCheck, remarks));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 4:
							System.out.print("Enter the Account Number");
							long acc = scan.nextLong();
							try {
								System.out.println(InternetObj.TransactionHistory(acc, id, loginCheck));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							System.out.print("Enter the Account Number");
							long acc1 = scan.nextLong();
							scan.nextLine();
							System.out.println("Enter the loan type");
							String ltype = scan.nextLine();
							try {
								System.out.println(InternetObj.loanStatus(acc1, id, loginCheck, ltype));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 6:
							System.out.print("Enter the Account Number");
							long acc2 = scan.nextLong();
							System.out.print("1.Educational Loan\n2.personal Loan\n3.business Loan \n4.Home Loan");
							scan.nextLine();
							System.out.print("Enter the loan type");
							String loantype = scan.nextLine();
							System.out.print("Enter the loan amount");
							int amount1 = scan.nextInt();
							Loan loan = new Loan();
							loan.setLoanAmount(amount1);
							loan.setLoanStatus(ApprovedStatus.NOT_APPROVED);
							loan.setLoanType(loantype);
							try {
								System.out.println(InternetObj.applyLoan(acc2, loan, id, loantype));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 7:
							temp = false;
							bool = true;
							break;
						}
					}
				}
				// Admin
				else if (loginCheck.equals("Admin")) {
					System.out.println("Login successful");
					bool = false;
					boolean temp = true;
					while (temp) {
						System.out.println(
								"2.Balance Check\n3.Bank Transfer\n4.Transaction History\n5.Check Loan Status\n6.Change Loan Status\n");

						int option = scan.nextInt();
						switch (option) {
						case 1:
							System.out.print("Enter the userid to create account");
							long userId = scan.nextLong();
							try {
								System.out.println(InternetObj.addAccount(userId, loginCheck));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 2:
							System.out.print("Enter the account number");
							int account1 = scan.nextInt();
							try {
								System.out.println(InternetObj.checkBalance(account1, loginCheck, id));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 3:
							System.out.print("Enter the from account number");
							long fromAcc = scan.nextLong();
							System.out.print("Enter the to account number");
							long toAcc = scan.nextLong();
							System.out.print("Enter the to amount");
							int amount = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the remarks");
							String remarks = scan.nextLine();

							try {
								System.out.println(
										InternetObj.transaction(fromAcc, amount, toAcc, id, loginCheck, remarks));
							} catch (Exception e) {
								e.getMessage();
							}
							break;
						case 4:
							System.out.print("Enter the Account Number");
							long acc = scan.nextLong();
							try {
								System.out.println(InternetObj.TransactionHistory(acc, id, loginCheck));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							System.out.print("Enter the Account Number");
							long acc1 = scan.nextLong();
							scan.nextLine();
							System.out.print("Enter the loan type");
							String type = scan.nextLine();
							try {
								System.out.println(InternetObj.loanStatus(acc1, id, loginCheck, type));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 6:
							System.out.println("Enter the Account Number");
							long acc2 = scan.nextLong();
							scan.nextLine();
							System.out.println("Enter the loan type");
							String loanType = scan.nextLine();
							System.out.println("1.Approved\n2.Not Approved\n3.Pending");
							System.out.println("Enter the loan status");
							int val = scan.nextInt();
							ApprovedStatus status = null;
							switch (val) {
							case 1: {
								status = ApprovedStatus.APPROVED;
								break;
							}
							case 2: {
								status = ApprovedStatus.NOT_APPROVED;
								break;
							}
							case 3: {
								status = ApprovedStatus.PENDING;
								break;
							}
							default: {
								System.out.println("Enter valid number");
							}
							}
							try {
								System.out.println(InternetObj.changeLoanStatus(acc2, status, loanType));
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							try {
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;
						case 7:
							temp = false;
							bool = true;
							break;
						}
					}
				}

				break;
			// create new account
			case 2:
				scan.nextLine();
				System.out.println("Enter the name");
				String name = scan.nextLine();
				System.out.println("Enter the phone number");
				long phone = scan.nextLong();
				System.out.println("Enter the account number");
				int account = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the password");
				String password1 = scan.nextLine();
				try {
					Customer cust = new Customer();
					cust.setName(name);
					cust.setPhoneNumber(phone);
					cust.setPassword(password1);
					cust.setUserID(phone);
					System.out.println(InternetObj.createUser(phone, account, password1, cust));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				bool = false;
				break;
			}
		}
		scan.close();
	}

}
