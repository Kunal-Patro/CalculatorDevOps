import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public Calculator()
    {

    }

    public static void main(String[] args) {
        double num1, num2;
        Calculator cal = new Calculator();
        Scanner scn = new Scanner(System.in);
        while(true)
        {
            System.out.println("-----Calculator---DevOps-----");
            System.out.println("     Choose to perform operations");
            System.out.println("1. To find factorial");
            System.out.println("2. To find square root");
            System.out.println("3. To find power");
            System.out.println("4. To find natural Logarithm");
            System.out.println("5. To exit");
            int ch;
            try{
                ch = scn.nextInt();
            }catch (InputMismatchException error)
            {
                System.out.println(error.getMessage());
                return;
            }
            switch (ch)
            {
                case 1:
                    System.out.print("Enter a number; ");
                    num1 = scn.nextDouble();
                    System.out.println("Factorial of " + num1 + " is : " + cal.factorial(num1));
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Exiting.....");
                    return;
            }
        }
    }

    public double factorial(double num1)
    {
        double result = fact(num1);
        return result;
    }

    public double fact(double num)
    {
        double f = 1;
        for(int i = 1; i <= num; i++)
        {
            f *= i;
        }
        return f;
    }
}
