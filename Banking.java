import java.util.Scanner;
import java.text.DecimalFormat;
public class Banking {

	public static  void banking() {
		Scanner scan = new Scanner(System.in);
		String cont = "";
		double balance = 100;
		boolean valid;
		String input;
		do {
		
			//ask user if they want to access banking services
			//loop repeats if input isn't Y or N
			//if else is so that user doesn't get the same message if they decide to use a second service
			if (!cont.equalsIgnoreCase("Y")) {
				System.out.println("Would you like to access banking services? y/n?");
				cont = scan.nextLine();
				checkContinue(cont);
			} else {
				System.out.println("Would you like to continue y/n?");
				cont = scan.nextLine();
				checkContinue(cont);
			}
			if (cont.equalsIgnoreCase("Y")) {
				System.out.println("Press 1 if you would like to view your account's current balance.");
				System.out.println("Press 2 if you would like to deposit money into your account.");
				System.out.println("Press 3 if you would like to make a withdrawl from your account.");
				do {
					input = scan.nextLine();
					valid = checkServiceInput(input);
				} while (valid != true);
				
				if (input.equals("1")) {
					outputBalance(balance);
				}
				if (input.equals("2")){ 
					System.out.println("Input the amount you would like to deposit.");
					double deposit = scan.nextDouble();
					scan.nextLine(); //catch the trailing enter
					balance = updateBalance(balance, deposit, false);
					outputBalance(balance);
				}
				if (input.equals("3")) {
					double withdrawl=0;
					do {
						System.out.println("Input the amount you would like to withdrawl.");
						withdrawl = scan.nextDouble();
						if (balance<withdrawl || withdrawl<0) { //negative numbers are also invalid input
							System.out.println("That is not a valid amount. Please try again.");
							outputBalance(balance);
						}
					} while (balance<withdrawl || withdrawl<0);
					updateBalance(balance, withdrawl, true);
					outputBalance(balance);
					scan.nextLine(); //catch the trailing enter
				}
			
			
			}
			
			
		} while (!cont.equalsIgnoreCase("N"));
		System.out.println("Thank you for using YearUp Banking Services. Have a nice day.");
		
		
	}
	public static void checkContinue(String str) {
		if(!str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase("N")) {
			//handling for invalid input for
			System.out.println("INVALID INPUT");
		}
	}
	public static boolean checkServiceInput(String str) {
		if(!str.equals("1") && !str.equals("2") && !str.equals("3")) {
			System.out.println("INVALID INPUT TRY AGAIN");
			return false;
		} else {
			return true;
		}
	}
	public static void outputBalance(double balance){
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Your current balance is $"+df.format(balance));
	}
	public static double updateBalance(double total, double changes, boolean withdrawl) {
		if(withdrawl==true) {
			total-=changes;
			System.out.println("You have withdrawn $"+changes);
		} else {
			total+=changes;
			System.out.println("You have deposited $"+changes);
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to YearUp Banking services.");
		System.out.println(); //spacing
		banking();
	}

}
