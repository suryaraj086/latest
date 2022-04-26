import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.BankException;

public class TempStore {

	Map<Long, Customer> userMap = new HashMap<Long, Customer>();
	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	Map<Long, List<Transaction>> transactionHistory = new HashMap<Long, List<Transaction>>();
	Map<Long, List<Long>> accounts = new HashMap<Long, List<Long>>();
	Map<Long, Map<String, Loan>> loan = new HashMap<Long, Map<String, Loan>>();

	public TempStore() {
		Customer cust = new Customer();
		cust.setUserID(1);
		cust.setPassword("1");
		cust.setRole(true);
		Long temp = (long) 1;
		userMap.put(temp, cust);
	}

	public String login(long userId, String password) throws BankException, Exception {

		if (userMap.get(userId) != null) {
			String pass = userMap.get(userId).getPassword();
			boolean role = userMap.get(userId).isRole();
			if (pass.equals(password) && !role) {
				return "Customer";
			}
			if (pass.equals(password) && role) {
				return "Admin";
			}
		}
		throw new BankException("Invalid username and password");
	}

	public String createUser(long phoneNumber, long accountNumber, String password, Customer cust)
			throws BankException, Exception {
		if (userMap.get(phoneNumber) == null) {
			userMap.put(phoneNumber, cust);
			Account info = new Account();
			info.setAccountNumber(accountNumber);
			accountMap.put(accountNumber, info);
			return "user id is " + phoneNumber + " and password is " + password;
		}
		throw new BankException("User already exists");
	}

	public String addAccount(long userId, String role) {
		List<Long> list = accounts.get(userId);
		Account acc = new Account();
		long b = 0;
		if (list == null) {
			list = new ArrayList<Long>();
		}
		long min = 1000;
		long max = 100000;
		b = (long) (Math.random() * (max - min + 1) + min);
		list.add(b);
		acc.setAccountNumber(b);
		accountMap.put(b, acc);
		accounts.put(userId, list);
		return "Account added successfully and your account number is " + b;
	}

	public long checkBalance(long accountNumber, String role, long userId) throws BankException, Exception {
		Account info = null;
		if (role.equals("Customer")) {
			checkAccount(accountNumber, userId);
		}
		info = accountCheck(accountNumber);
		return info.getBalance();
	}

	public Account accountCheck(long accountNumber) throws BankException, Exception {
		Account info = accountMap.get(accountNumber);
		if (info == null) {
			throw new BankException("Account Not Found");
		}
		return info;
	}

	public String deposit(long accountNumber, long amount) throws BankException, Exception {
		Account info = accountCheck(accountNumber);
		long balance = info.getBalance();
		long newBalance = balance + amount;
		info.setBalance(newBalance);
		return "Transaction Successful";
	}

	public String withdraw(long accountNumber, int amount) throws BankException, Exception {
		Account info = accountCheck(accountNumber);
		long balance = info.getBalance();
		long newBalance = balance - amount;
		info.setBalance(newBalance);
		return "Transaction Successful";
	}

	public String transaction(long fromAccount, long amount, long toAccount, long userId, String role, String remarks)
			throws BankException, Exception {
		if (role.equals("Customer")) {
			checkAccount(fromAccount, userId);
		}
		if (remarks == null) {
			throw new BankException("Transaction failed");
		}
		Account info = accountCheck(fromAccount);
		Account info1 = accountCheck(toAccount);
		long balance = info.getBalance();
		long balance1 = info1.getBalance();
		long fromBalance = balance - amount;
		long toBalance = balance1 + amount;
		info.setBalance(fromBalance);
		info1.setBalance(toBalance);
		Transaction transfer = ObjectSetter.transferSetter(amount, fromBalance, fromAccount, toAccount, remarks);
		Transaction transfer1 = ObjectSetter.transferSetter(amount, toBalance, fromAccount, toAccount, remarks);
		if (transactionHistory.get(fromAccount) == null) {
			List<Transaction> list = new ArrayList<Transaction>();
			list.add(transfer);
			transactionHistory.put(fromAccount, list);
			list.clear();
			list.add(transfer1);
			transactionHistory.put(toAccount, list);
		}
		transactionHistory.get(fromAccount).add(transfer);
		return "Transaction Successful";
	}

	public Object loanStatus(long accountNumber, long userId, String role, String loantype)
			throws BankException, Exception {
		if (role.equals("Customer")) {
			checkAccount(accountNumber, userId);
		}
		accountCheck(accountNumber);
		Map<String, Loan> loans = loan.get(accountNumber);
		if (loans.get(loantype) != null) {
			Loan loanObj = loans.get(loantype);
			return loanObj.getLoanStatus();
		}
		return "Account Not Found or Not Applied for loan";
	}

	public String changeLoanStatus(long account, ApprovedStatus status, String loanType)
			throws BankException, Exception {
		accountCheck(account);
		Map<String, Loan> loans = loan.get(account);
		if (loans != null) {
			Loan temp = loans.get(loanType);
			temp.setLoanStatus(status);
			return "Status Changed";
		}
		return "Account Not Found";
	}

	public String applyLoan(Long account, Loan loans, long userId, String loanType) throws BankException, Exception {
		checkAccount(account, userId);
		Map<String, Loan> map = new HashMap<String, Loan>();
		map.put(loanType, loans);
		loan.put(account, map);
		return "Applied Successfully";
	}

	public String TransactionHistory(long accountNumber, long userId, String role) throws BankException, Exception {
		if (role.equals("Customer")) {
			checkAccount(accountNumber, userId);
		}
		List<Transaction> list = transactionHistory.get(accountNumber);
		String out = "";
		for (int i = list.size() - 1; i >= 0; i--) {
			Transaction transfer = (Transaction) list.get(i);
			out += "Transferred from " + transfer.getFromAccount();
			out += " to " + transfer.getToAccount();
			out += " amount " + transfer.getAmount();
			out += " balance is " + transfer.getBalance();
			out += " and time is " + new java.util.Date(transfer.getTime());
			out += " , remarks " + transfer.getRemarks();
			out += "\n";
		}
		return out;
	}

	public boolean checkAccount(long account, long userId) throws BankException, Exception {
		List<Long> list = accounts.get(userId);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				long acc = list.get(i);
				if (acc == account) {
					return true;
				}
			}
		}
		throw new BankException("Account Not Found");
	}

	public Long account(long id) {
		List<Long> list = accounts.get(id);
		if (list.size() > 1) {
			return (long) 0;
		}
		return (Long) list.get(0);
	}

}
