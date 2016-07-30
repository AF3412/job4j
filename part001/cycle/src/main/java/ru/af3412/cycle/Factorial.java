package af3412;

public class Factorial{
	
		int value;

		public Factorial(int value){
			this.value = value;
		}

		int calculate(){
			int result = 1;
			if (value != 0)
				for (int index = 1; index <= value; index++){
					result = result * index;
			}
			return result;
		}

}