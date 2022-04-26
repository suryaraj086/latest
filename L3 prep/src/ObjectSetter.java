
public class ObjectSetter {

	public static Transaction transferSetter(long amount, long fromBalance, long fromAccount, long toAccount, String remarks) {
		Transaction transfer = new Transaction();
		transfer.setAmount(amount);
		transfer.setBalance(fromBalance);
		transfer.setFromAccount(fromAccount);
		transfer.setToAccount(toAccount);
		transfer.setRemarks(remarks);
		return transfer;
	}

}
