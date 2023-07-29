package _04_netflix;

public class NetflixRunner {
	public static void main(String[] args) {

		Movie twilight = new Movie ("Twilight", 1);
		Movie topGun = new Movie ("Top Gun: Maverick", 5);
		Movie jaws = new Movie ("Jaws", 2);
		Movie avatarWayOfWater = new Movie ("Avatar: Way of Water", 4);
		Movie cars = new Movie ("Cars", 2);

		System.out.println(twilight.getTicketPrice());


		NetflixQueue queue = new NetflixQueue ();

		queue.addMovie(twilight);
		queue.addMovie(topGun);
		queue.addMovie(jaws);
		queue.addMovie(avatarWayOfWater);
		queue.addMovie(cars);

		queue.printMovies();	


		System.out.println("The best movie is " + queue.getBestMovie());

		System.out.println("The worst movie is " + queue.getMovie(4));



	}
}
