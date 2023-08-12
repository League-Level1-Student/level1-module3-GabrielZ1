package _06_frogger;

import processing.core.PApplet;

public class Frogger extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	int size = 50;
	int frogX = WIDTH/2;
	int frogY = HEIGHT-size;
	int frogHopDistance = 21;


	Car car1;
	Car car2;
	Car car3;


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {

		car1 = new Car(0,100,100,10);
		car2 = new Car(700,250,100,8);
		car3 = new Car(0,400,100,6);


	}

	@Override
	public void draw() {
		background(100,180,200);
		fill(0,255,0);
		ellipse(frogX, frogY, size, size);



		car1.driveRight();
		car1.display();

		car2.driveLeft();
		car2.display();

		car3.driveRight();
		car3.display();



		if(car1.intersects(car1)) {
			frogX = WIDTH/2;
			frogY = HEIGHT-size;
		}
		if(car2.intersects(car2)) {
			frogX = WIDTH/2;
			frogY = HEIGHT-size;
		}
		if(car3.intersects(car3)) {
			frogX = WIDTH/2;
			frogY = HEIGHT-size;
		}




	}


	public void keyPressed() {
		if(key == CODED){
			if(keyCode == UP && frogY>size/2) {
				frogY -= frogHopDistance;
			}
			else if(keyCode == DOWN && frogY<HEIGHT-size/2) {
				frogY += frogHopDistance;
			}
			else if(keyCode == RIGHT && frogX<WIDTH-size/2) {
				frogX += frogHopDistance;
			}
			else if(keyCode == LEFT && frogX>size/2) {
				frogX -= frogHopDistance;
			}
		}
	}


	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
	}



	public class Car {
		int carX;
		int carY;
		int carSize;
		int carSpeed;

		public Car(int carX, int carY, int carSize, int carSpeed) {
			this.carX = carX;
			this.carY = carY;
			this.carSize = carSize;
			this.carSpeed = carSpeed;
		}

		void display() {
			fill(0,255,0);
			rect(carX, carY, carSize, 50);

		}

		public void driveLeft() {
			carX = carX - carSpeed;

			if(carX <= 0-100) {
				carX = WIDTH;

			}
		}

		public void driveRight() {
			carX = carX + carSpeed;

			if(carX >= WIDTH) {
				carX = 0-100;

			}
		}


		public int getX() {
			return carX;
		}

		public int getY() {
			return carY;
		}

		public int getSize() {
			return carSize;
		}


		boolean intersects(Car car) {
			if ((frogY > car.getY() && frogY < car.getY()+size) &&
					(frogX > car.getX() && frogX < car.getX()+car.getSize())) {
				return true;
			}
			else  {
				return false;
			}

		}

	}

}

