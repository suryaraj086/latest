
import exception.BankException;

public class InternetBanking {

	TempStore cache = new TempStore();

	public String login(long userId, String password) throws BankException, Exception {
		return cache.login(userId, password);
	}

	public String createUser(long phoneNumber, long accountNumber, String password, Customer cust)
			throws BankException, Exception {
		return cache.createUser(phoneNumber, accountNumber, password, cust);
	}

	public String addAccount(long userId, String role) {
		return cache.addAccount(userId, role);
	}

	public long checkBalance(long accountNumber, String role, long userId) throws BankException, Exception {
		return cache.checkBalance(accountNumber, role, userId);
	}

	public Account accountCheck(long accountNumber) throws BankException, Exception {
		return cache.accountCheck(accountNumber);
	}

	public String deposit(long accountNumber, long amount) throws BankException, Exception {
		return cache.deposit(accountNumber, amount);
	}

	public String withdraw(long accountNumber, int amount) throws BankException, Exception {
		return cache.withdraw(accountNumber, amount);
	}

	public String transaction(long fromAccount, long amount, long toAccount, long userId, String role, String remarks)
			throws BankException, Exception {
		return cache.transaction(fromAccount, amount, toAccount, userId, role, remarks);
	}

	public Object loanStatus(long accountNumber, long userId, String role, String loantype)
			throws BankException, Exception {
		return cache.loanStatus(accountNumber, userId, role, loantype);
	}

	public String changeLoanStatus(long account, ApprovedStatus status, String loanType)
			throws BankException, Exception {
		return cache.changeLoanStatus(account, status, loanType);
	}

	public String applyLoan(long account, Loan loan, long userId, String loanType) throws BankException, Exception {
		return cache.applyLoan(account, loan, userId, loanType);
	}

	public String TransactionHistory(long accountNumber, long userId, String role) throws BankException, Exception {
		return cache.TransactionHistory(accountNumber, userId, role);
	}

	public boolean checkAccount(long account, long userId) throws BankException, Exception {
		return cache.checkAccount(account, userId);
	}

	public Long account(long id) {
		return cache.account(id);
	}
}
