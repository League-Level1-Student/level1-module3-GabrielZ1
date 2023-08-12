package _06_frogger;

import processing.core.PApplet;
import processing.core.PImage;

public class FroggerWithImages extends PApplet {
	static final int WIDTH = 844;
	static final int HEIGHT = 600;

	int size = 75;
	int frogX = WIDTH/2-size;
	int frogY = HEIGHT-size;
	int frogHopDistance = 21;


	Car car1;
	Car car2;
	Car car3;

	PImage back;
	PImage carLeft;
	PImage carRight;
	PImage frog;


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {

		back = loadImage("src/_06_frogger/froggerBackground.png");
		carLeft = loadImage("src/_06_frogger/carLeft.png");
		carLeft.resize(160,100);
		carRight = loadImage("src/_06_frogger/carRight.png");
		carRight.resize(160,100);
		frog = loadImage("src/_06_frogger/frog.png");
		frog.resize(75,75);

		car1 = new Car(0,135,10);
		car2 = new Car(WIDTH-160,285,8);
		car3 = new Car(0,435,6);


	}

	@Override
	public void draw() {
		
		background(back);
		image (frog, frogX, frogY);



		car1.driveRight();
		car1.displayRight();

		car2.driveLeft();
		car2.displayLeft();

		car3.driveRight();
		car3.displayRight();



		if(car1.intersects(car1)) {
			frogX = WIDTH/2-size;
			frogY = HEIGHT-size;
		}
		if(car2.intersects(car2)) {
			frogX = WIDTH/2-size;
			frogY = HEIGHT-size;
		}
		if(car3.intersects(car3)) {
			frogX = WIDTH/2-size;
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
		PApplet.main(FroggerWithImages.class.getName());
	}



	public class Car {
		int carX;
		int carY;
		int carSize = 160;
		int carSpeed;

		public Car(int carX, int carY, int carSpeed) {
			this.carX = carX;
			this.carY = carY;
			this.carSpeed = carSpeed;
		}

		void displayRight() {
			image(carRight, carX, carY);

		}
		
		void displayLeft() {
			image(carLeft, carX, carY);
			
		}

		
		public void driveLeft() {
			carX = carX - carSpeed;

			if(carX <= 0-160) {
				carX = WIDTH;

			}
		}

		public void driveRight() {
			carX = carX + carSpeed;

			if(carX >= WIDTH) {
				carX = 0-160;

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
