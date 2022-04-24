import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.BankException;

public class InternetBanking {

	Cache cache = new Cache();

	public String login(long userId, String password) throws BankException, Exception {

		if (cache.userMap.get(userId) != null) {
			String pass = cache.userMap.get(userId).getPassword();
			boolean role = cache.userMap.get(userId).isRole();
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
		if (cache.userMap.get(phoneNumber) == null) {
			cache.userMap.put(phoneNumber, cust);
			Account info = new Account();
			info.setAccountNumber(accountNumber);
			cache.accountMap.put(accountNumber, info);
			return "user id is " + phoneNumber + " and password is " + password;
		}
		throw new BankException("User already exists");
	}

	public String addAccount(long userId, String role) {
		List<Long> list = cache.accounts.get(userId);
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
		cache.accountMap.put(b, acc);
		cache.accounts.put(userId, list);
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
		Account info = cache.accountMap.get(accountNumber);
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
		Transaction transfer = new Transaction();
		transfer.setAmount(amount);
		transfer.setBalance(fromBalance);
		transfer.setFromAccount(fromAccount);
		transfer.setToAccount(toAccount);
		transfer.setRemarks(remarks);
		Transaction transfer1 = new Transaction();
		transfer1.setAmount(amount);
		transfer1.setBalance(fromBalance);
		transfer1.setFromAccount(fromAccount);
		transfer1.setToAccount(toAccount);
		transfer1.setRemarks(remarks);
		if (cache.transactionHistory.get(fromAccount) == null) {
			List<Transaction> list = new ArrayList<Transaction>();
			list.add(transfer);
			cache.transactionHistory.put(fromAccount, list);
			list.clear();
			list.add(transfer1);
			cache.transactionHistory.put(toAccount, list);
		}
		cache.transactionHistory.get(fromAccount).add(transfer);
		return "Transaction Successful";
	}

	public Object loanStatus(long accountNumber, long userId, String role, String loantype)
			throws BankException, Exception {
		if (role.equals("Customer")) {
			checkAccount(accountNumber, userId);
		}
		accountCheck(accountNumber);
		Map<String, Loan> loan = cache.loan.get(accountNumber);
		if (loan.get(loantype) != null) {
			Loan loanObj = loan.get(loantype);
			return loanObj.getLoanStatus();
		}
		return "Account Not Found or Not Applied for loan";
	}

	public String changeLoanStatus(long account, ApprovedStatus status, String loanType)
			throws BankException, Exception {
		accountCheck(account);
		Map<String, Loan> loan = cache.loan.get(account);
		if (loan != null) {
			Loan temp = loan.get(loanType);
			temp.setLoanStatus(status);
			return "Status Changed";
		}
		return "Account Not Found";
	}

	public String applyLoan(long account, Loan loan, long userId, String loanType) throws BankException, Exception {
		checkAccount(account, userId);
		Map<String, Loan> map = new HashMap<String, Loan>();
		map.put(loanType, loan);
		cache.loan.put(account, map);
		return "Applied Successfully";
	}

	public String TransactionHistory(long accountNumber, long userId, String role) throws BankException, Exception {
		if (role.equals("Customer")) {
			checkAccount(accountNumber, userId);
		}
		List<Transaction> list = cache.transactionHistory.get(accountNumber);
		String out = "";
		for (int i = list.size() - 1; i >= 0; i--) {
			Transaction transfer = (Transaction) list.get(i);
			out += "Transferred from " + transfer.getFromAccount();
			out += " to " + transfer.getToAccount();
			out += " amount " + transfer.getAmount();
			out += " balance is " + transfer.getBalance();
			out += " and time is " + transfer.getTime();
			out += " , remarks " + transfer.getRemarks();
			out += "\n";
		}
		return out;
	}

	public boolean checkAccount(long account, long userId) throws BankException, Exception {
		List<Long> list = cache.accounts.get(userId);
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
		List<Long> list = cache.accounts.get(id);
		if (list.size() > 1) {
			return (long) 0;
		}
		return (Long) list.get(0);
	}
}
