package _05_cow_timer;

public class CowTimerRunner {
	public static void main(String[] args) throws InterruptedException {
		/* Make a CowTimer, set its time and start it.
		 * Use a short delay (seconds) when testing, then try with longer delays
		 */

		CowTimer cowTimer = new CowTimer(10); //this sets the cow timer to 10 seconds
		cowTimer.start();

	}
}
