package cycle;

/**
 * The type Init cube function.
 */
class InitCubeFunction {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int first = Integer.valueOf(args[0]);
        int second = Integer.valueOf(args[1]);

        CubeFunction cubeFunctionOne = new CubeFunction(1, 1, 1);

        for (int index = first; index <= second; index++) {
            System.out.println(cubeFunctionOne.calculate(index));
        }

    }
}