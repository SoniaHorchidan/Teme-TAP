
public class Rectangle implements Comparable <Rectangle> {
	double width;
	double height;
	
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public int compareTo(Rectangle R){
		if(this.Area() < R.Area())
			return -1;
		else 
			if(this.Area() > R.Area())
				return 1;
		return 0;
	}
	
	private double Area(){
		return width*height;
	}
	
	public String toString(){
		return this.width + "  " + this.height + "  " + this.Area() + "\n";

	}
}
