

public class Transaction {

	long time = System.currentTimeMillis();
	long fromAccount;
	long toAccount;
	long amount;
	long balance;
	String remarks = "Not set";

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
