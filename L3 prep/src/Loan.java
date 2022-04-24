
public class Loan {
	String loanType;
	long loanAmount;
	ApprovedStatus loanStatus;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public ApprovedStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(ApprovedStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

}
