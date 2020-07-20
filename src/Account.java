import java.util.Random;

public class Account {
	private String firstName;
	private String lastName;
	private double balance;
	private long accNum;

	private static int accountTotal;

	Random rand = new Random();

	public Account() {};

	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		setBalance(balance);
		setAccNum(accNum);
		accountTotal++;
	}

	public Account(String firstName, String lastName, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		setBalance(balance);
		setAccNum(accNum);
		accountTotal++;
	}

	public Account(String firstName, String lastName, double balance, long accNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		setBalance(balance);
		setAccNum(accNum);
		accountTotal++;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public void setBalance(double balance) {
		this.balance = (balance > 0) ? balance : 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccNum(long accNum) {
		this.accNum = Math.abs(rand.nextLong());
	}

	public long getAccNum() {
		return accNum;
	}

	public static int getAccountTotal() {
		return accountTotal;
	}

	public void withdrawMoney(double amount) {
//		balance -= (amount <= balance && amount >= 0) ? amount : 0.00;
		amount = (amount > 0) ? amount : 0.00;
		if (balance >= amount) {
			balance -= amount;
		}
		 else {
			System.out.println("Balance insufficient");
		}
	}

	public static Account consolidatedAccount(Account acct1, Account acct2) {
		if ((acct1.getName().equals(acct2.getName())) && (acct1.getAccNum() != acct2.getAccNum())) {
			var newAccount = new Account("Steve", "Ansah");
			System.out.println("Account consolidated");
			newAccount.setAccNum(0);
			newAccount.balance = acct1.balance + acct2.balance;
			System.out.println("Name: " + newAccount.getName());
			System.out.println("Account Number: " +newAccount.getAccNum());
			System.out.println("Balance: " + newAccount.getBalance());
			acct1.closed();
			acct2.closed();
			System.out.println("Account Total: " + accountTotal);
		return newAccount;
		}
		System.out.println("Couldn't consolidate. Two different account names");
		return acct1;
	}

	public void depositMoney(double amount) {
		amount = (amount > 0) ? amount : 0.00;
		balance += amount;
	}

	public void closed() {
		setBalance(0);
		lastName = lastName + " - CLOSED";
		accountTotal--;
	}

	public void transfer(Account acct, Account acct2, double amount) {
		acct.balance += acct2.balance - amount;
		acct2.balance -= amount;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\n%s\t$%,.02f\n%s\t%d\n%s\t%d",
				"Name:", getName(), "Balance:", getBalance(), "Account Number:", getAccNum(),
				"Account Total:", accountTotal);
	}
}
