package geometry;

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
    public boolean exists() {
        double distOne = a.distanceTo(b);
        double distTwo = b.distanceTo(c);
        double distThree = c.distanceTo(a);

        return (distOne < distTwo + distThree) & (distTwo < distOne + distThree) & (distThree < distOne + distTwo);
    }

    /**
     * Area double.
     *
     * @return the double
     */
    public double area() {
        //calculate the triangle area
        if (this.exists()) {
            double distOne = a.distanceTo(b);
            double distTwo = b.distanceTo(c);
            double distThree = c.distanceTo(a);
            double halfPrmtr = ((distOne + distTwo + distThree) / 2);
            double areaTriangle = Math.sqrt(halfPrmtr * (halfPrmtr - distOne) * (halfPrmtr - distTwo) * (halfPrmtr - distThree));
            return areaTriangle;
        } else {
            return -1;
        }

    }
}