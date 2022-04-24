package exception;

public class BankException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankException(String error) throws Exception {
		throw new Exception(error);
	}
}
