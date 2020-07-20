public class Main {
	public static void main(String[] args) {

		var account = new Account("Steve", "Ansah", 2000, 0);
		var account2 = new Account("Dennis", "Stone");
		var account3 = new Account("Steve", "Ansah", 500);


		System.out.println(account.getBalance());

		System.out.println();

		account.transfer(account, account3, 200);
		System.out.println("After transfer");
		System.out.println(account);
		System.out.println("\n" + account3);
		System.out.println();
//
//		Account.consolidatedAccount(account, account3);
//
//		System.out.println("\n" + account);
	}
}
