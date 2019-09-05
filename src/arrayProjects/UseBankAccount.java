package arrayProjects;

public class UseBankAccount {

	public UseBankAccount() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		//THE TYPE IS INT, THE VARIABLE IS X 
		int x=0;
		
		
				
		//TYPE IS bANK ACCOUNT THE VARAIBLE IS OPENED
		BankAccount opened = new BankAccount ();
		
		BankAccount myBank = new BankAccount ();
		
		BankAccount yourBank = new BankAccount ();
		
		
		myBank.setPassword ("mypassword");
		
		yourBank.setPassword("Yourpassword");
		
		System.out.println(opened.getPassword());

		opened.setPassword ("supersecret");
		
		System.out.println(opened.getPassword());
		
		System.out.println(myBank.getPassword());
		
		System.out.println(yourBank.getPassword());
	}
	

}
