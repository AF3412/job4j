package af3412;

public class InitTriangle {
	public static void main(String[] args) {
	
		Point a = new Point(0, 0);
		Point b = new Point(1, 0);
		Point c = new Point(0, 1);

		Triangle triangle_one = new Triangle(a, b, c);

		if (triangle_one.exists())
			System.out.println("Triangle area: " + triangle_one.area());
		else
			System.out.println("Triangle doesn't exist!");

		//Task №2
		MaxDistance maxDist = new MaxDistance(triangle_one.a.distanceTo(triangle_one.b), triangle_one.b.distanceTo(triangle_one.c));
		MaxDistance maxDist2 = new MaxDistance(maxDist.max(), triangle_one.c.distanceTo(triangle_one.a));
		System.out.println("Max size: " + maxDist2.max());

	}
}