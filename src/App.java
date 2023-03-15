package package1;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.print("To start the game press s or S" + "\n");
		Scanner scanner = new Scanner(System.in);
		String response = scanner.next();
		while(!response.equals("s") && !response.equals("S")) {
			System.out.print("Wrong input, try again" + "\n");
			response = scanner.next();
		}
		startGame();
		scanner.close();
		
	}
	static String startGame() {
		System.out.print("Welocme to the Number Guessing Game" + "\n" + "You should guess number between 1 and 5" + "\n" + "You have 3 attempts" + "\n");
		int attempts = 3;
		Scanner scanner = new Scanner(System.in);
		int numResponse = scanner.nextInt();
		int rndNum = newNumber();
		System.out.print("random => " + rndNum + "\n");
			while(attempts > 1) {
				if(checkNumbers(numResponse, rndNum)) {
					System.out.print("You win!!!" + "\n");
					endGame();
					break;
				}else {
					attempts--;
					System.out.print("Wrong, you have " + attempts + " attempts left");
					numResponse = scanner.nextInt();
				}
			}
		endGame();
		scanner.close();
		return null;
	}
	
	static int newNumber() {
		Random random = new Random();
		int num = random.nextInt(5) + 1;
		return num;
	}
	
	static String endGame() {
		System.out.print("Thanks for playing");
		return null;
	}
	
	static boolean checkNumbers(int userNum, int num) {
		if(userNum == num) {
			return true;
		}
		return false;
	}
}
