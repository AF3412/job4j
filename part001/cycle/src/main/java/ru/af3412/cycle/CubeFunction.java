package af3412;

class CubeFunction{
	float a, b, c;

	public CubeFunction(float a, float b, float c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	float calculate(int x){
		return ((x * x * a) + (b * x) + c);
	}

}