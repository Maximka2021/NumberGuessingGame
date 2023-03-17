package package1;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

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
		boolean isWin = false;
		int score = 100;
		int attempts = 3;
		int rndNum = newNumber();
		System.out.print("Random Number => " + rndNum);
		Scanner scanner = new Scanner(System.in);
		int numResponse = scanner.nextInt();
			while(numResponse != rndNum) {
				if(attempts == 1) {
					System.out.print("You are out of attempts Loser" + "\n");
					showScore(isWin, score);
					break;
				}
				attempts--;
				System.out.print("Wrong, you have " + attempts + " left" + "\n");
				numResponse = scanner.nextInt();
			}
			if(numResponse == rndNum) {
				System.out.print("You Win" + "\n" + "Score: " + (score * attempts) + "\n");
				isWin = true;
				int finalScore = score * attempts;
				showScore(isWin, finalScore);
			}
		scanner.close();
		return null;
	}
	
	private static int newNumber() {
		Random random = new Random();
		int num = random.nextInt(5) + 1;
		return num;
	}
	
	private static String endGame() {
		System.out.print("Thanks for playing");
		return null;
	}
	
	static ScoreBoard[] showScore(boolean isWin, int score) {
		ScoreBoard p1 = new ScoreBoard("Maxim", 200);
		ScoreBoard p2 = new ScoreBoard("Angel", 100);
		ScoreBoard p3 = new ScoreBoard("Aaron", 300);
		ArrayList<ScoreBoard> scores = new ArrayList();
		scores.add(p1);
		scores.add(p2);
		scores.add(p3);
		System.out.print("Press b to see score board");
		Scanner scanner = new Scanner(System.in);
		String boardResp = scanner.next();
		while(!boardResp.equals("b")) {
			System.out.print("Unknown Input" + "\n");
			boardResp = scanner.next();
		}
		for(int i = 0; i < scores.size(); i++) {
			System.out.print(scores.get(i));
		}
		if(isWin == true) {
			System.out.print("Press y to add your score or press q to end the game" + "\n");
			String addResp = scanner.next();
			if(addResp.equals("y")) {
				System.out.print("Enter your username =>  ");
				String username = scanner.next();
				ScoreBoard newScore = new ScoreBoard(username, score);
				scores.add(newScore);
				for(int i = 0; i < scores.size(); i++) {
					System.out.print(scores.get(i));
				}
				endGame();
			}else {
				endGame();
			}
		}else {
			endGame();
		}
		return null;
	}
	
}
