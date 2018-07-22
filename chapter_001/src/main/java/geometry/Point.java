package geometry;

/**
 * The type Point.
 */
public class Point {
    /**
     * The X.
     */
    public double x;
    /**
     * The Y.
     */
    public double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance to double.
     *
     * @param point the point
     * @return the double
     */
    public double distanceTo(Point point) {
        //calculate distance between two points
        double distance = Math.sqrt((Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2)));
        return distance;
    }
}