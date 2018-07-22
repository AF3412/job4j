package geometry;

/**
 * The type Init triangle.
 */
public class InitTriangle {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);

        Triangle triangleOne = new Triangle(a, b, c);

        if (triangleOne.exists()) {
            System.out.println("Triangle area: " + triangleOne.area());
        } else {
            System.out.println("Triangle doesn't exist!");
        }

        //Task №2
        MaxDistance maxDist = new MaxDistance(triangleOne.a.distanceTo(triangleOne.b), triangleOne.b.distanceTo(triangleOne.c));
        MaxDistance maxDist2 = new MaxDistance(maxDist.max(), triangleOne.c.distanceTo(triangleOne.a));
        System.out.println("Max size: " + maxDist2.max());

    }
}