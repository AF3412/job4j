package cycle;

/**
 * The type Cube function.
 */
class CubeFunction {
    /**
     * The A.
     */
    float a, /**
     * The B.
     */
    b, /**
     * The C.
     */
    c;

    /**
     * Instantiates a new Cube function.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     */
    public CubeFunction(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculate float.
     *
     * @param x the x
     * @return the float
     */
    float calculate(int x) {
        return ((x * x * a) + (b * x) + c);
    }

}