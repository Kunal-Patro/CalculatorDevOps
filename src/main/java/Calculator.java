import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
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
            System.out.println("1. To find power");
            System.out.println("2. To find square root");
            System.out.println("3. To find factorial");
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
                    System.out.print("Enter the first number : ");
                    num1 = scn.nextDouble();
                    System.out.print("Enter the second number : ");
                    num2 = scn.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + cal.power(num1, num2));
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.print("Enter a number : ");
                    num1 = scn.nextDouble();
                    System.out.println("Square root of "+num1+" is : " + cal.sqroot(num1));
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.print("Enter a number; ");
                    num1 = scn.nextDouble();
                    System.out.println("Factorial of " + num1 + " is : " + cal.factorial(num1));
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.print("Enter a number : ");
                    num1 = scn.nextDouble();
                    System.out.println("Natural log of "+num1+" is : " + cal.naturalLog(num1));
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
        logger.info("[Factorial] - " + num1);
        double result = fact(num1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }

    public double sqroot(double num1) {
        logger.info("[SQUARE ROOT] - " + num1);
        double result = Math.sqrt(num1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public double power(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double num1) {
        logger.info("[NATURAL LOG] - " + num1);
        double result = 0;
        try {

            if (num1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(num1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
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
