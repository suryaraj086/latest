import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

	Map<Long, Customer> userMap = new HashMap<Long, Customer>();
	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	Map<Long, List<Transaction>> transactionHistory = new HashMap<Long, List<Transaction>>();
	Map<Long, List<Long>> accounts = new HashMap<Long, List<Long>>();
	Map<Long, Map<String, Loan>> loan = new HashMap<Long, Map<String, Loan>>();

	public Cache() {
		Customer cust = new Customer();
		cust.setUserID(1);
		cust.setPassword("1");
		cust.setRole(true);
		Long temp = (long) 1;
		userMap.put(temp, cust);
	}
}
