package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;


public class Dragon {
	private Point2D speed; 
	private Point2D position; 
	private int widthOfWorld;
	private int hightOfWorld;
	private World world; 
	
	
	public Dragon(Point2D speed, Point2D position, int widthOfWorld, int hightOfWorld, World world) {
		this.speed = speed;
		this.position = position;
		this.widthOfWorld = widthOfWorld;
		this.hightOfWorld = hightOfWorld;
		this.world = world; 
	} 
	
	public void draw(GraphicsContext gc) {
		Point2D canvasPosition = world.getCanvasPoint(position);
		gc.drawImage(Constants.DRAGON_IMAGE, canvasPosition.getX(), canvasPosition.getY(), 80, 80);
	}
	
	public void simulation(double deltaT) {
		position = new Point2D(position.getX() + speed.getX()*deltaT /500, position.getY() + speed.getY()*deltaT/500);
		position = new Point2D((position.getX() + widthOfWorld)%widthOfWorld,(position.getY() + widthOfWorld)%widthOfWorld); 
	}
}