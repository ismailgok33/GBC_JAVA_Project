import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PreviousGameResult {

	private String datePlayed = "";
	private int points = 0;
	
	public PreviousGameResult(int points) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		datePlayed = dtf.format(LocalDateTime.now()).toString();
		this.points = points;
	}
	
	public String toString() {
		return "Date: " + datePlayed + ", score: " + points;
	}
	
}
