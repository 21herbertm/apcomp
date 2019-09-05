package arrayProjects;

public class BankAccount {
	private String password;
	private double balance;
	private String name;
	private int accountNum;

	public BankAccount() {
		password = "constructor assigned password";
		balance = 0.0;
		
	}
	
	public BankAccount(String p, double b) {
		password = p;
		balance = b;
		
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String p) {
		password=p;
	}
	
	
	
	
	
}
