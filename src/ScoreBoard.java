package package1;

public class ScoreBoard {
	String username;
	int score;
	ScoreBoard(String username, int score){
		this.username = username;
		this.score = score;
	}
	
	public String toString(){
		return this.username + " " + this.score + "\n";
	}
}
