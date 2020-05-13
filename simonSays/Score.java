package simonSays;

public class Score {

	int score = 0;
	
	public void score(String result) {
		if (result == "WIN") {
			score++;
		} else {
			score--;
		}
		System.out.println(score);
	}
	
}
