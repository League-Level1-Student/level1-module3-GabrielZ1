package _06_frogger;

import processing.core.PApplet;

public class Frogger extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	int size = 50;
	int frogX = WIDTH/2;
	int frogY = HEIGHT-size;



	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {





	}

	@Override
	public void draw() {
		background(100,180,200);
		fill(0,255,0);
		ellipse(frogX, frogY, size, size);

	}


	public void keyPressed() {
		if(key == CODED){
			if(keyCode == UP && frogY>size/2) {
				frogY -= 25;
			}
			else if(keyCode == DOWN && frogY<HEIGHT-size/2) {
				frogY += 25;
			}
			else if(keyCode == RIGHT && frogX<WIDTH-size/2) {
				frogX += 25;
			}
			else if(keyCode == LEFT && frogX>size/2) {
				frogX -= 25;
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
			rect(carX, carY, size, 50);
			//CURRENTLY ON RECIPE STEP 10
		}


	}



}

