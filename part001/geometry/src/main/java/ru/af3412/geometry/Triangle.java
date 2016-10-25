package af3412;

/**
 * The type Triangle.
 */
public class Triangle {
    /**
     * The A.
     */
    public Point a;
    /**
     * The B.
     */
    public Point b;
    /**
     * The C.
     */
    public Point c;

    /**
     * Instantiates a new Triangle.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     */
    public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

    /**
     * Exists boolean.
     *
     * @return the boolean
     */
    public boolean exists(){
		double dist_one = a.distanceTo(b);
		double dist_two = b.distanceTo(c);
		double dist_three = c.distanceTo(a);

		if ((dist_one < dist_two + dist_three) & (dist_two < dist_one + dist_three) & (dist_three < dist_one + dist_two))
			return true;
		else return false;
	}

    /**
     * Area double.
     *
     * @return the double
     */
    public double area() {
		//calculate the triangle area
		if (this.exists()) {
			double dist_one = a.distanceTo(b);
			double dist_two = b.distanceTo(c);
			double dist_three = c.distanceTo(a);
			double half_prmtr = ((dist_one + dist_two + dist_three) / 2);
			double area_triangle = Math.sqrt(half_prmtr*(half_prmtr - dist_one)*(half_prmtr - dist_two)*(half_prmtr - dist_three));	
			return area_triangle;
		}
		else return -1;
		
	}
}