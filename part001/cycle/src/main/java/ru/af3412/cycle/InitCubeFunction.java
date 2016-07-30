package af3412;

class InitCubeFunction{
	public static void main(String[] args) {

		int first = Integer.valueOf(args[0]);
		int second = Integer.valueOf(args[1]);

		CubeFunction cubeFunctionOne = new CubeFunction(1, 1, 1);

		for (int index = first; index <= second; index++){
			System.out.println(cubeFunctionOne.calculate(index));
		}

	}
}