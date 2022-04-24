import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
	LocalDate myObj = LocalDate.now();
	LocalTime myObj1 = LocalTime.now();
	String time = myObj.toString() + " " + myObj1.toString();
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
