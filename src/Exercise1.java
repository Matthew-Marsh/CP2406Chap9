import java.math.BigInteger;
import java.util.Scanner;

public class Exercise1 {


    private static final BigInteger one  = new BigInteger("1");
    private static final BigInteger zero = new BigInteger("0");
    private static final BigInteger two = new BigInteger("2");

    static BigInteger fibonacci(BigInteger number) {
        if (number.equals(one) || number.equals(zero)) {
            return one;
        } else {
            return fibonacci(number.subtract(one)).add(fibonacci(number.subtract(two)));
        }
    }

    static BigInteger factorial(BigInteger number) {
        if (number.equals(zero)) {
            return one;
        } else {
            BigInteger subtractedNumber = factorial(number.subtract(one));
            return number.multiply(subtractedNumber);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an integer that is over zero: ");
            int number = userInput.nextInt();
            if (number == 0) {
                break;
            } else if (number < 0) {
                System.out.println("Number must be postive.");
                continue;
            }
            BigInteger bigNumber = BigInteger.valueOf(number);
            System.out.println("Fibonnaci of " + number + " is " + fibonacci(bigNumber));

            System.out.println("Factorial of " + number + " is " + factorial(bigNumber));

        }
    }
}
