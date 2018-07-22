package calculator;

/**
 * The type Calc init.
 */
public class CalcInit {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {

        double first = 5;
        double second = 6;

        Calculator calc1 = new Calculator();
        calc1.add(first, second);
        calc1.printResult();
        calc1.substruct(first, second);
        calc1.printResult();
        calc1.div(first, second);
        calc1.printResult();
        calc1.multiple(first, second);
        calc1.printResult();
    }
}