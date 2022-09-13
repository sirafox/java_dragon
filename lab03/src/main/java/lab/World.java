package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class World {
	private BulletAnimated bulletAnimatted;
	private Cannon cannon;
	private final Dragon dragon;
	private final Canvas canvas;

	public World(Canvas canvas) {
		super();
		this.canvas = canvas;
		cannon = new Cannon(this, new Point2D(50, 50), new Point2D(100, 20));
		bulletAnimatted = new BulletAnimated(this, cannon, new Point2D(30, 60), new Point2D(0, 0), 40);
		dragons = new Dragon[] {
				new Dragon(new Point2D(20, 65), new Point2D(60, 60), (int) canvas.getWidth(),(int)canvas.getHeight(), this);
				new Dragon(new Point2D(40, 65), new Point2D(150, 200), (int) canvas.getWidth(),(int)canvas.getHeight(), this);
				new Dragon(new Point2D(-40, 65), new Point2D(15, 20), (int) canvas.getWidth(),(int)canvas.getHeight(), this);
	
		}
	}

	public Point2D getCanvasPoint(Point2D worldPoint) {
		return new Point2D(worldPoint.getX(), canvas.getHeight() - worldPoint.getY());
	}

	public void draw() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		cannon.draw(gc);
		bulletAnimatted.draw(gc);
		for (Dragon, dragon, dragons) {
			dragon.draw(gc);
		};
	}

	public void simulate(double timeDelta) {
		bulletAnimatted.simulate(timeDelta);
		cannon.simulate(timeDelta);
		dragon.simulation(timeDelta);
	}


}
